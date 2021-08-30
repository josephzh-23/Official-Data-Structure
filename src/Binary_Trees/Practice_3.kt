package Binary_Trees

import java.util.*


fun main () {
    // 1
    //2 ->  3
    // loop thru each node first
    val root =TreeNode(5)
    val test2 = TreeNode(6)
    val test3 =TreeNode(7)
    val test4 = TreeNode(7)

    val test5 =TreeNode(7)


    root.left = test2
    root.right = test3
    test2.left = test4
    test2.right = test5


    val i =0

    var s = Solution3()
    val result = s.connect(root)



    }
internal class Solution3 {
    fun connect(root: TreeNode?): TreeNode? {
        if (root == null) {
            return root
        }

        // Initialize a queue data structure which contains
        // just the root of the tree
        val Q: Queue<TreeNode> = LinkedList<TreeNode>()
        Q.add(root)

        // Outer while loop which iterates over
        // each level
        while (Q.size > 0) {

            // Note the size of the queue
            val size = Q.size

            // Iterate over all the nodes on the current level
            for (i in 0 until size) {

                // Pop a node from the front of the queue
                val node: TreeNode = Q.poll()

                // This check is important. We don't want to
                // establish any wrong connections. The queue will
                // contain nodes from 2 levels at most at any
                // point in time. This check ensures we only
                // don't establish next pointers beyond the end
                // of a level
                if (i < size - 1) {
                    node.next = Q.peek()
                }

                // Add the children, if any, to the back of
                // the queue
                if (node.left != null) {
                    Q.add(node.left)
                }
                if (node.right != null) {
                    Q.add(node.right)
                }
            }
        }

        // Since the tree has now been modified, return the root node
        return root
    }
}
