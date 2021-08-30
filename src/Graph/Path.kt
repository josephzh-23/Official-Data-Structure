package Graph

class Path {

  /*
   Here we are storing nodes, in real life
   can store citiies, person or something like that

   */

  private val nodes: MutableList<String> = ArrayList()
  fun add(node: String) {
    nodes.add(node)
  }

  override fun toString(): String {
    return nodes.toString()
  }
}