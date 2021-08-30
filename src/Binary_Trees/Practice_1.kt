package Binary_Trees


/*
Use in order traversal to print elements

Input: root = [1,null,2,3]
Output: [1,3,2]
 */
fun main() {

    val test = TreeNode(5)
    val test2 = TreeNode(6)
    val test3 = TreeNode(7)


    test.left =test2
    test.right = test3
    // COnstruct a tree in java first
    var s = Solution()
    var list = s.inorderTraversal(test)
    list.forEach{
        print(it)
    }

}
   class Solution {


        // Add all the values to a list here
        fun inorderTraversal(root: TreeNode?): List<Int> {

            val res: MutableList<Int> = ArrayList()
            helper(root, res)
            return res
        }

        fun helper(root: TreeNode?, res: MutableList<Int>) {
            if (root != null) {
                if (root.left != null) {
                    helper(root.left, res)
                }

                // Add the root to the list until we get to the leaf node
                res.add(root.value)
                if (root.right != null) {
                    helper(root.right, res)
                }
            }
        }
    }

