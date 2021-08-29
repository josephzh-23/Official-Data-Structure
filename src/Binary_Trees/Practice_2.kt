package Binary_Trees


// Based on question 2
/*
Given the root of a binary tree,
return the level order traversal of its nodes' values. (i.e., from left to right, level by level).


 */
fun main (){

    var arr = arrayOf( 3,9,20,null,null,15,7)



    val test = TreeNode(5)
    val test2 = TreeNode(6)
    val test3 = TreeNode(7)


    test.left =test2
    test.right = test3
    // COnstruct a tree in java first
    var s = Solution2()
    var list = s.levelOrder(test)

    list.forEach{
        print(it)
    }
}

internal class Solution2 {
    // level: 1           2
    // Ex:  [5] ,    [6, 7]
    var levels: MutableList<MutableList<Int>> = ArrayList()

    fun helper(node: TreeNode?, level: Int) {

        // start the current level with an emply list
        if (levels.size == level) levels.add(ArrayList())

        // fulfil the current level
        // levels[0]    ->  [ 1, 2, 4]
        levels[level].add(node!!.`val`)

        // If leaf nodes this will end
        if (node.left != null) helper(node.left, level + 1)
        if (node.right != null) helper(node.right, level + 1)
    }

    // Here you have a list of lists
    fun levelOrder(root: TreeNode?): List<MutableList<Int>> {

        // A lot of time this is the return condition
        if (root == null) return levels
        helper(root, 0)
        return levels
    }

}