package Graph

import java.util.*
import java.util.function.ToIntFunction

class WeightedGraph {
  private inner class Node(val label: String) {
    private val edges: MutableList<Edge> = ArrayList()
    override fun toString(): String {
      return label
    }

    fun addEdge(to: Node?, weight: Int) {
      edges.add(Edge(this, to!!, weight))
    }

    fun getEdges(): List<Edge> {
      return edges
    }
  }

  private inner class Edge(val from: Node, val to: Node, val weight: Int) {
    override fun toString(): String {
      return "$from->$to" // A->B
    }
  }

  private val nodes: MutableMap<String, Node> = HashMap()
  fun addNode(label: String) {
    nodes.putIfAbsent(label, Node(label))
  }

  fun addEdge(from: String, to: String, weight: Int) {
    val fromNode = nodes[from] ?: throw IllegalArgumentException()
    val toNode = nodes[to] ?: throw IllegalArgumentException()
    fromNode.addEdge(toNode, weight)
    toNode.addEdge(fromNode, weight)
  }

  fun print() {
    for (node in nodes.values) {
      val edges = node.getEdges()
      if (!edges.isEmpty()) println("$node is connected to $edges")
    }
  }

  private inner class NodeEntry(val node: Node, val priority: Int)

  /*
  Return the path object
   */
  fun getShortestPath(from: String, to: String): Path {
    val fromNode = nodes[from] ?: throw IllegalArgumentException()


    val toNode = nodes[to] ?: throw IllegalArgumentException()
    val distances: MutableMap<Node, Int> = HashMap()

    for (node in nodes.values) distances[node] = Int.MAX_VALUE
    distances.replace(fromNode, 0)


    // Hashtable for storign previous nodes

    val previousNodes: MutableMap<Node, Node> = HashMap()
    val visited: MutableSet<Node> = HashSet()


    val queue = PriorityQueue(
      Comparator.comparingInt { ne: NodeEntry -> ne.priority }
    )
    queue.add(NodeEntry(fromNode, 0))
    while (!queue.isEmpty()) {
      val current = queue.remove().node
      visited.add(current)
      for (edge in current.getEdges()) {
        if (visited.contains(edge.to)) continue
        val newDistance = distances[current]!! + edge.weight
        if (newDistance < distances[edge.to]!!) {
          distances.replace(edge.to, newDistance)

          /*
          When we find a shorter path, will update the
          previousNodes table.
           */
          previousNodes[edge.to] = current
          queue.add(NodeEntry(edge.to, newDistance))
        }
      }
    }

    // Used to build the shortest path here
    return buildPath(previousNodes, toNode)
  }

  private fun buildPath(
    previousNodes: Map<Node, Node>, toNode: Node
  ): Path {

    val stack = Stack<Node>()

    // Add ending node to stack
    stack.push(toNode)

    // Find all previous nodes
    var previous = previousNodes[toNode]
    while (previous != null) {
      stack.push(previous)

      // Set the previous to previous of current node
      previous = previousNodes[previous]
    }
    val path = Path()
    while (!stack.isEmpty()) path.add(stack.pop().label)
    return path
  }

  fun hasCycle(): Boolean {
    val visited: MutableSet<Node> = HashSet()
    for (node in nodes.values) {
      if (!visited.contains(node) &&
        hasCycle(node, null, visited)
      ) return true
    }
    return false
  }

  private fun hasCycle(
    node: Node, parent: Node?,
    visited: MutableSet<Node>
  ): Boolean {
    visited.add(node)
    for (edge in node.getEdges()) {
      if (edge.to === parent) continue
      if (visited.contains(edge.to) ||
        hasCycle(edge.to, node, visited)
      ) return true
    }
    return false
  }

  val minimumSpanningTree: WeightedGraph
    get() {
      val tree = WeightedGraph()
      if (nodes.isEmpty()) return tree
      val edges = PriorityQueue(
        Comparator.comparingInt { e: Edge -> e.weight }
      )
      val startNode = nodes.values.iterator().next()
      edges.addAll(startNode.getEdges())
      tree.addNode(startNode.label)
      if (edges.isEmpty()) return tree
      while (tree.nodes.size < nodes.size) {
        val minEdge = edges.remove()
        val nextNode = minEdge.to
        if (tree.containsNode(nextNode.label)) continue
        tree.addNode(nextNode.label)
        tree.addEdge(
          minEdge.from.label,
          nextNode.label, minEdge.weight
        )
        for (edge in nextNode.getEdges()) if (!tree.containsNode(edge.to.label)) edges.add(edge)
      }
      return tree
    }

  fun containsNode(label: String): Boolean {
    return nodes.containsKey(label)
  }

  // The Dijikskar's method as mentioned before
  fun getShortestDistance(from: String?, to: String?): Int {

    // fromNode : our starting node
    val fromNode: Node? = nodes[from]

    /*
  2 maps, distances and the nodes
   */
    /*
    The distances map table that we wanted
    [starting node,   distance to it]
     */
    val distances: MutableMap<Node?, Int> =
      HashMap<Node?, Int>()

    /*
     For every node in this graph, we need to add an entry
     in the hashtable,
     */for (node in nodes.values) {
      distances[node] = Int.MAX_VALUE
    }

    // Set the distance of the starting node to itself to 0
    distances.replace(fromNode, 0)
    val visited = HashSet<Any>()
    val queue = PriorityQueue(
      Comparator.comparingInt { ne: NodeEntry -> ne.priority }
    )

    // Here add starting node to our queue
    // it will have prioirty 0
    queue.add(NodeEntry(fromNode!!, 0))
    while (!queue.isEmpty()) {
      // current: the node we want to examine
      val current: Node = queue.remove().node
      visited.add(current)
      for (edge in current.getEdges()) {

        // edge.to is the neighboring node
        if (visited.contains(edge.to)) continue

        /*
        Distance.get(current)   means the distance from staring to current

         */
        val newDistance: Int = distances[current]!! + edge.weight
        if (newDistance < distances[edge.to]!!) {

          // Replace distance for the negibbhor node with
          // new distance
          distances.replace(edge.to, newDistance)

          /*
          If the distance is shorter, this entry will
          be moved to beginning of priority queue
           */
          queue.add(NodeEntry(edge.to, newDistance))
        }
      }
      queue.remove().node
    }

    /*
    When queue empty, we can return the shortest distance
    to the target node
     */return distances[nodes[to]]!!
  }
}