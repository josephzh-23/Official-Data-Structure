package Binary_Trees


   class Node(var `val`: Int) {
       var left: Node? = null
       var right: Node? = null
       var next: Node? = null
   }

fun main () {
    // 1
    //2 ->  3
    // loop thru each node first
    val root = Node(5)
    val test2 = Node(6)
    val test3 = Node(7)
    val test4 = Node(7)

    val test5 = Node(7)


    root.left = test2
    root.right = test3
    test2.left = test4
    test2.right = test5
    val s = Practice_3.Solution3()

    val height =  s.height(root)

    print(height)


    val i =0

        for (i in 0..height) {
            for (value in s.getNodesAtDistance(root, i)) println(value)
        }


}
class Practice_3 {



    class Solution3 {
//        fun connect(root: Node?): Node? {
//
//        }


        // Will find the height of a node
        // The way to check for is Leaf is clear and simple
        fun height(root: Node?): Int {
            // A base condition is always needed
            if (root == null) return -1
            return if (isLeaf(root)) 0 else 1 + Math.max(
                    height(root.left),
                    height(root.right)
            )
        }


        fun isLeaf(node: Node): Boolean {
            return node!!.left == null && node.right == null
        }

        fun getNodesAtDistance(root: Node?, distance: Int, list: ArrayList<Int>) {
            if (root == null) return
            if (distance == 0) {
                list.add(root.`val`)
                return
            }

            getNodesAtDistance(root?.left, distance - 1, list)
            getNodesAtDistance(root?.right, distance - 1, list)
        }

        // THis is modified  to include the root node

        fun getNodesAtDistance(root: Node, distance: Int): ArrayList<Int> {
            val list = ArrayList<Int>()
            getNodesAtDistance(root, distance, list)
            return list
        }

//    fun traverseLevelOrder() {
//        for (i in 0..height()) {
//            for (value in getNodesAtDistance(i)) println(value)
//        }
//    }
    }
    }

