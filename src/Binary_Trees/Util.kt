package Binary_Trees

// Will find the height of a node
// The way to check for is Leaf is clear and simple
fun height(root: TreeNode?): Int {
    // A base condition is always needed
    if (root == null) return -1
    return if (isLeaf(root)) 0 else 1 + Math.max(
        height(root.left),
        height(root.right)
    )
}


fun isLeaf(node: TreeNode): Boolean {
    return node!!.left == null && node.right == null
}

fun getNodesAtDistance(root: TreeNode?, distance: Int, list: ArrayList<Int>) {
    if (root == null) return
    if (distance == 0) {
        list.add(root.value)
        return
    }

    getNodesAtDistance(root?.left, distance - 1, list)
    getNodesAtDistance(root?.right, distance - 1, list)
}

// THis is modified  to include the root node

fun getNodesAtDistance(root: TreeNode, distance: Int): ArrayList<Int> {
    val list = ArrayList<Int>()
    getNodesAtDistance(root, distance, list)
    return list
}


