package Binary_Trees


class Tree {
    inner class Node(val value: Int) {
        var leftChild: Node? = null
        var rightChild: Node? = null
        override fun toString(): String {
            return "Node=$value"
        }
    }

    private var root: Node? = null
    fun insert(value: Int) {
        val node: Node = Node(value)
        if (root == null) {
            root = node
            return
        }
        var current = root
        while (true) {

            if (value < current!!.value) {

                // We have reached the bottom here
                if (current.leftChild == null) {
                    current.leftChild = node
                    break
                }
                current = current.leftChild
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node
                    break
                }
                current = current.rightChild
            }
        }
    }

    fun find(value: Int): Boolean {
        var current = root
        while (current != null) {
            current =
                if (value < current.value) current.leftChild else if (value > current.value) current.rightChild else return true
        }
        return false
    }

    fun traversePreOrder() {
        traversePreOrder(root)
    }

    private fun traversePreOrder(root: Node?) {
        if (root == null) return
        println(root.value)
        traversePreOrder(root.leftChild)
        traversePreOrder(root.rightChild)
    }

    fun traverseInOrder() {
        traverseInOrder(root)
    }

    private fun traverseInOrder(root: Node?) {
        if (root == null) return
        traverseInOrder(root.leftChild)
        println(root.value)
        traverseInOrder(root.rightChild)
    }

    fun traversePostOrder() {
        traversePostOrder(root)
    }

    private fun traversePostOrder(root: Node?) {
        if (root == null) return
        traversePostOrder(root.leftChild)
        traversePostOrder(root.rightChild)
        println(root.value)
    }

    fun height(): Int {
        return height(root)
    }


    // Will find the height of a node
    // The way to check for is Leaf is clear and simple
    private fun height(root: Node?): Int {
        // A base condition is always needed
        if (root == null) return -1
        return if (isLeaf(root)) 0 else 1 + Math.max(
            height(root.leftChild),
            height(root.rightChild)
        )
    }

    private fun isLeaf(node: Node?): Boolean {
        return node!!.leftChild == null && node.rightChild == null
    }

    // O(log n) -> used for binary search tree
    /*
        And we keep traversing down until we find
        the left most child

     */
    fun min(): Int {
        checkNotNull(root)
        var current = root
        var last = current
        while (current != null) {
            last = current
            current = current.leftChild
        }
        return last!!.value
    }

    // O(n)     -> used for Binary tree
    private fun min(root: Node?): Int {
        if (isLeaf(root)) return root!!.value

        val left = min(root!!.leftChild)
        val right = min(root.rightChild)

        // Find the min out of all 3 values
        return Math.min(Math.min(left, right), root.value)
    }

    fun equals(other: Tree?): Boolean {
        return if (other == null) false else equals(root, other.root)
    }

    private fun equals(first: Node?, second: Node?): Boolean {
        if (first == null && second == null) return true
        return if (first != null && second != null) first.value == second.value && equals(
            first.leftChild,
            second.leftChild
        )
                && equals(first.rightChild, second.rightChild) else false
    }

    // Used to be called
    fun isBinarySearchTree(): Boolean
    {
       return isBinarySearchTree(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    /*
    [ min , max] will be the acceptable range that's passed in
        if node is not within that range
            then return false
     */
    private fun isBinarySearchTree(root: Node?, min: Int, max: Int): Boolean {

        if (root == null) return true
        return if (root.value < min || root.value > max) false else


            isBinarySearchTree(
            root.leftChild,
            min,
            root.value - 1
        )
                && isBinarySearchTree(root.rightChild, root.value + 1, max)
    }

    fun getNodesAtDistance(distance: Int): ArrayList<Int> {
        val list = ArrayList<Int>()
        getNodesAtDistance(root, distance, list)
        return list
    }

    private fun getNodesAtDistance(root: Node?, distance: Int, list: ArrayList<Int>) {
        if (root == null) return
        if (distance == 0) {
            list.add(root.value)
            return
        }
        getNodesAtDistance(root.leftChild, distance - 1, list)
        getNodesAtDistance(root.rightChild, distance - 1, list)
    }

    fun traverseLevelOrder() {
        for (i in 0..height()) {
            for (value in getNodesAtDistance(i)) println(value)
        }
    }

    fun size(): Int {
        return size(root)
    }

    // Size will keep calling itself for left child
    // until it has no children

    /*
    Notice that each time the recursion happens
        -> size (root.leftChild)   or size(root.RightChild)
        -> gives 1 if they exist
         because of 1 + in here
     */
    private fun size(root: Node?): Int {
        if (root == null) return 0
        return if (isLeaf(root)) 1 else 1 + size(root.leftChild) + size(root.rightChild)
    }

    fun countLeaves(): Int {
        return countLeaves(root)
    }

    private fun countLeaves(root: Node?): Int {
        if (root == null) return 0
        return if (isLeaf(root)) 1 else countLeaves(root.leftChild) + countLeaves(root.rightChild)
    }

    fun max(): Int {
        checkNotNull(root)
        return max(root)
    }

    //This fxn will keep going until no more rightChild
    // Could have
    /*
     7
        10
     */
    private fun max(root: Node?): Int {
        return if (root!!.rightChild == null) root.value else max(root.rightChild)
    }


//    // ANother test here
//    fun size_test(root: Node): Int {
//
//    }
    operator fun contains(value: Int): Boolean {
        return contains(root, value)
    }



    private fun contains(root: Node?, value: Int): Boolean {
        if (root == null) return false
        return if (root.value == value) true else contains(root.leftChild, value) || contains(root.rightChild, value)
    }

    fun areSibling(first: Int, second: Int): Boolean {
        return areSibling(root, first, second)
    }

    private fun areSibling(root: Node?, first: Int, second: Int): Boolean {
        if (root == null) return false
        var areSibling = false
        if (root.leftChild != null && root.rightChild != null) {
            areSibling = root.leftChild!!.value == first && root!!.rightChild?.value == second ||
                    root!!.rightChild?.value == first && root!!.leftChild?.value == second
        }
        return areSibling ||
                areSibling(root.leftChild, first, second) ||
                areSibling(root.rightChild, first, second)
    }

    fun getAncestors(value: Int): List<Int> {
        val list = ArrayList<Int>()
        getAncestors(root, value, list)
        return list
    }

    private fun getAncestors(root: Node?, value: Int, list: MutableList<Int>): Boolean {
        // We should traverse the tree until we find the target value. If
        // find the target value, we return true without adding the current node
        // to the list; otherwise, if we ask for ancestors of 5, 5 will be also
        // added to the list.
        if (root == null) return false
        if (root.value == value) return true

        // If we find the target value in the left or right sub-trees, that means
        // the current node (root) is one of the ancestors. So we add it to the list.
        if (getAncestors(root.leftChild, value, list) ||
            getAncestors(root.rightChild, value, list)
        ) {
            list.add(root.value)
            return true
        }
        return false
    }

    val isBalanced: Boolean
        get() = isBalanced(root)

    private fun isBalanced(root: Node?): Boolean {
        if (root == null) return true
        val balanceFactor = height(root.leftChild) - height(root.rightChild)
        return Math.abs(balanceFactor) <= 1 &&
                isBalanced(root.leftChild) &&
                isBalanced(root.rightChild)
    }



    val isPerfect: Boolean
        get() = size().toDouble() == Math.pow(2.0, (height() + 1).toDouble()) - 1
}