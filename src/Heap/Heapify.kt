package Heap


object MaxHeap {
    fun heapify(array: IntArray) {
        val lastParentIndex = array.size / 2 - 1
        for (i in lastParentIndex downTo 0) heapify(array, i)
    }

    private fun heapify(array: IntArray, index: Int) {
        // Assume the root index has the largest index
        var largerIndex = index

        val leftIndex = index * 2 + 1

        /*
         Need to reset the largerIndex to left Idx
             if    array[leftIndex] > array[largerIndex]
        */

        if (leftIndex < array.size &&
            array[leftIndex] > array[largerIndex]
        ) largerIndex = leftIndex
        val rightIndex = index * 2 + 2

        if (rightIndex < array.size &&
            array[rightIndex] > array[largerIndex]
        ) largerIndex = rightIndex

        /*
            If index == laregrIndex
            the item is > both of its children
                thus item is in the right position

         */
        if (index == largerIndex) return
        /*
            If not in the right position swap with the bigger item
         */
        swap(array, index, largerIndex)
        heapify(array, largerIndex)
    }

    private fun swap(array: IntArray, first: Int, second: Int) {
        val temp = array[first]
        array[first] = array[second]
        array[second] = temp
    }

    fun getKthLargest(array: IntArray, k: Int): Int {
        require(!(k < 1 || k > array.size))
        val heap = Heap()
        for (number in array) heap.insert(number)
        for (i in 0 until k - 1) heap.remove()
        return heap.max()
    }
}
