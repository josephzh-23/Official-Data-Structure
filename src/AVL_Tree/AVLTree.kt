package AVL_Tree


class AVLTree {
    private inner class AVLNode(val value: Int) {
        var height = 0
        var leftChild: AVLNode? = null
        var rightChild: AVLNode? = null
        override fun toString(): String {
            return "Value=" + value
        }
    }

    private var root: AVLNode? = null

    // And usig this value
    // THis recursion will end when the root is null
    fun insert(value: Int) {


        root = insert(root, value)
    }

    // A recursive function here again
    private fun insert(root: AVLNode?, value: Int): AVLNode? {

        /*
        The first time inserting root will be null
        when root = null, this whole recursion will then end
         */
        if (root == null) return AVLNode(value)


        if (value < root.value) root.leftChild = insert(root.leftChild, value)
        else root.rightChild = insert(root.rightChild, value)

        /*
        ALso need to reset the height of the root as well
         */
         setHeight(root)
        return balance(root)
    }

    private fun balance(root: AVLNode): AVLNode? {


        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0) root.leftChild = rotateLeft(root.leftChild)
            return rotateRight(root)
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0) root.rightChild = rotateRight(root.rightChild)
            return rotateLeft(root)
        }
        return root
    }

    private fun rotateLeft(root: AVLNode?): AVLNode? {
        val newRoot = root!!.rightChild
        root.rightChild = newRoot!!.leftChild
        newRoot.leftChild = root
        setHeight(root)
        setHeight(newRoot)
        return newRoot
    }

    private fun rotateRight(root: AVLNode?): AVLNode? {
        val newRoot = root!!.leftChild

        root.leftChild = newRoot!!.rightChild
        newRoot.rightChild = root

        // Need to update the
        setHeight(root)
        setHeight(newRoot)
        return newRoot
    }

    private fun setHeight(node: AVLNode?) {
        node!!.height = Math.max(
            height(node.leftChild),
            height(node.rightChild)
        ) + 1
    }

    private fun isLeftHeavy(node: AVLNode): Boolean {
        return balanceFactor(node) > 1
    }

    private fun isRightHeavy(node: AVLNode): Boolean {
        return balanceFactor(node) < -1
    }

    private fun balanceFactor(node: AVLNode?): Int {
        return if (node == null) 0 else height(node.leftChild) - height(node.rightChild)
    }


    // Get the height if it exists
    private fun height(node: AVLNode?): Int {
        return node?.height ?: -1
    }
}
