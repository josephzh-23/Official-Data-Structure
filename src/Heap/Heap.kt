package Heap



class Heap {
    private val items = IntArray(10)
    private var size = 0
    fun insert(value: Int) {
        check(!isFull)
        items[size++] = value
        bubbleUp()
    }

    fun remove(): Int {
        check(!isEmpty)
        val root = items[0]

        // Set root to be the last element in the array
        items[0] = items[size -1 ]

        // Using size --, we delete the last element frmo the array
        size--

        // if item(root) < children, used to move the 'root' down so
        // it will be the smallest element again
        bubbleDown()
        return root
    }

    private fun bubbleDown() {
        var index = 0

        // Need to update the index here
        // index will keep getting larger here
        while (index <= size && !isValidParent(index)) {
            val largerChildIndex = largerChildIndex(index)
            swap(index, largerChildIndex)

            // reset index to the larger child index
            // b/c we want to continously bubble down this item
            // if it's smaller than its children
            index = largerChildIndex
        }
    }

    val isEmpty: Boolean
        get() = size == 0

    private fun largerChildIndex(index: Int): Int {
        if (!hasLeftChild(index)) return index
        if (!hasRightChild(index)) return leftChildIndex(index)
        return if (leftChild(index) > rightChild(index)) leftChildIndex(index) else rightChildIndex(index)
    }

    // To validate the index
    // make sure index is < # of items in the heap
    private fun hasLeftChild(index: Int): Boolean {
        return leftChildIndex(index) <= size
    }

    // Get the right child index
    // make sure index is < # of items in the heap

    private fun hasRightChild(index: Int): Boolean {
        return rightChildIndex(index) <= size
    }

    // A node is a valid parent when it's > both of its children
    private fun isValidParent(index: Int): Boolean {
        if (!hasLeftChild(index)) return true
        var isValid = items[index] >= leftChild(index)
        if (hasRightChild(index)) isValid = isValid and (items[index] >= rightChild(index))
        return isValid
    }

    private fun rightChild(index: Int): Int {
        return items[rightChildIndex(index)]
    }

    // Used to get left cihld element
    private fun leftChild(index: Int): Int {
        return items[leftChildIndex(index)]
    }

    private fun leftChildIndex(index: Int): Int {
        return index * 2 + 1
    }


    private fun rightChildIndex(index: Int): Int {
        return index * 2 + 2
    }

    val isFull: Boolean
        get() = size == items.size

    private fun bubbleUp() {
        var index = size - 1

        // Need to reset the parent index
        // parent() -> get parent index each time b/c it changes

        // if item inserted greater than its paprent

        while (index > 0 && items[index] > items[parent(index)]) {
            swap(index, parent(index))

            // Update the index using parent index
            index = parent(index)
        }
    }

    private fun parent(index: Int): Int {
        return (index - 1) / 2
    }

    private fun swap(first: Int, second: Int) {
        val temp = items[first]
        items[first] = items[second]
        items[second] = temp
    }

    fun max(): Int {
        check(!isEmpty)
        return items[0]
    }

    companion object {
        fun isMaxHeap(array: IntArray): Boolean {
            return isMaxHeap(array, 0)
        }

        private fun isMaxHeap(array: IntArray, index: Int): Boolean {
            // All leaf nodes are valid
            val lastParentIndex = (array.size - 2) / 2
            if (index > lastParentIndex) return true
            val leftChildIndex = index * 2 + 1
            val rightChildIndex = index * 2 + 2
            val isValidParent = array[index] >= array[leftChildIndex] &&
                    array[index] >= array[rightChildIndex]
            return isValidParent &&
                    isMaxHeap(array, leftChildIndex) &&
                    isMaxHeap(array, rightChildIndex)
        }
    }
}
