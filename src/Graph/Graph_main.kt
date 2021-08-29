package Graph

fun main(){
    var graph = Graph()
    graph.addNode("A")
    graph.addNode("B")
    graph.addNode("C")
    graph.addEdge("A", "C")
    graph.addEdge("A", "B")
    graph.removeNode("B")
//    graph.print()
    graph.addEdge("C", "A")

    graph.traverseDepthFirstRec("C")

    graph.traverseBreadthFirst("C")


    // Testing out topogloical order graph
    var graph2 = Graph()
    graph2.addNode("X")
    graph2.addNode("A")
    graph2.addNode("B")
    graph2.addNode("P")
    graph2.addEdge("X", "A")
    graph2.addEdge("X", "B")
    graph2.addEdge("A", "P")
    graph2.addEdge("B", "P")

    var list = graph2.topologicalSort()
}