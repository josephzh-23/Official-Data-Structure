package Graph

import java.util.*


class Graph {
    private inner class Node(val label: String) {
        override fun toString(): String {
            return label
        }
    }

    private val nodes: MutableMap<String, Node> = HashMap()

    // < node , the list of nodes each node connected to>
    private val adjacencyList: MutableMap<Node, MutableList<Node>> = HashMap()

    // Used to add a node to here
    fun addNode(label: String) {
        val node: Node = Node(label)
        nodes.putIfAbsent(label, node)
        adjacencyList.putIfAbsent(node, ArrayList())
    }

    fun addEdge(from: String, to: String) {
        val fromNode = nodes[from] ?: throw IllegalArgumentException()
        val toNode = nodes[to] ?: throw IllegalArgumentException()
        adjacencyList[fromNode]!!.add(toNode)
    }

    fun print() {
        for (source in adjacencyList.keys) {
            val targets: List<Node> = adjacencyList[source]!!
            if (!targets.isEmpty()) println("$source is connected to $targets")
        }
    }

    fun removeNode(label: String) {
        val node: Node = nodes[label] ?: return

        // get all the keys, which would be every node in the graph
        for (n in adjacencyList.keys)


        // adjacencyList[n] -> gets you all the nodes that n is connected with
            // and we remove that node
            adjacencyList[n]!!.remove(node)


        // THen we remove the node from adjList and all the ndoes
        adjacencyList.remove(node)
//        nodes.remove(node)
        nodes.remove(label, node)
    }

    // Always need form and to
    fun removeEdge(from: String, to: String) {
        val fromNode = nodes[from]
        val toNode = nodes[to]
        if (fromNode == null || toNode == null) return
        adjacencyList[fromNode]!!.remove(toNode)
    }

    fun traverseDepthFirstRec(root: String) {
        val node = nodes[root] ?: return
        traverseDepthFirstRec(node, HashSet())
    }

    // This is the iterative process, you add sth to this
    // and you keep track of what's already visited.

    // Note the root changes all the time
    private fun traverseDepthFirstRec(root: Node, visited: MutableSet<Node>) {
        println(root)

        visited.add(root)

        /*
         for each node in the list assocaited with current node
            if we haven't visited that node -> traverse it
         */

        for (node in adjacencyList[root]!!)
            if (!visited.contains(node)) traverseDepthFirstRec(node, visited)
    }

    // This is the iterative process, no recursion here
    fun traverseDepthFirst(root: String) {
        val node = nodes[root] ?: return
        val visited: MutableSet<Node> = HashSet()
        val stack = Stack<Node>()
        stack.push(node)
        while (!stack.isEmpty()) {
            val current = stack.pop()

            // make sure we haven't visited this node before
            if (visited.contains(current)) continue
            println(current)
            visited.add(current)

            // Then look at all its unvisited neighbor here of
            // current node
            for (neighbour in adjacencyList[current]!!) if (!visited.contains(neighbour)) stack.push(neighbour)
        }
    }


    // Note with tree we have done a breadth first traversal here

    fun traverseBreadthFirst(root: String) {
        val node = nodes[root] ?: return
        val visited: MutableSet<Node> = HashSet()
        val queue: Queue<Node> = ArrayDeque()

        queue.add(node)
        while (!queue.isEmpty()) {

            // Poll from the queue if not empty
            val current = queue.remove()
            if (visited.contains(current)) continue
            println(current)
            visited.add(current)

            // Here we visit the neighbor associated with each eleme
            for (neighbour in adjacencyList[current]!!) if (!visited.contains(neighbour)) queue.add(neighbour)
        }
    }

    fun topologicalSort(): List<String> {
        val stack = Stack<Node>()
        val visited: MutableSet<Node> = HashSet()

        // For each node in our table,
        // Do a sort
        for (node in nodes.values) topologicalSort(node, visited, stack)
        val sorted: MutableList<String> = ArrayList()


        while (!stack.empty()) sorted.add(stack.pop().label)
        return sorted
    }

    private fun topologicalSort(
            node: Node, visited: MutableSet<Node>, stack: Stack<Node>) {

        // Make sure not visiting same node 2x
        if (visited.contains(node)) return
        visited.add(node)

        // Next visit all children of this node
        // Neighbor -> same as a child
        for (neighbour in adjacencyList[node]!!){
            topologicalSort(neighbour, visited, stack)
        }

        // Once we have visited all its children push this node to stack
        /*
            The node here would be at the bottom of the list
         */
        stack.push(node)
    }

    // Check if any cycle here
    fun hasCycle(): Boolean {
        val all: MutableSet<Node> = HashSet()
        all.addAll(nodes.values)
        val visiting: MutableSet<Node> = HashSet()
        val visited: MutableSet<Node> = HashSet()
        while (!all.isEmpty()) {
            val current = all.iterator().next()
            if (hasCycle(current, all, visiting, visited)) return true
        }
        return false
    }

    private fun hasCycle(node: Node, all: MutableSet<Node>,
                         visiting: MutableSet<Node>, visited: MutableSet<Node>): Boolean {
        all.remove(node)
        visiting.add(node)
        for (neighbour in adjacencyList[node]!!) {
            if (visited.contains(neighbour)) continue
            if (visiting.contains(neighbour)) return true
            if (hasCycle(neighbour, all, visiting, visited)) return true
        }
        visiting.remove(node)
        visited.add(node)
        return false
    }
}
