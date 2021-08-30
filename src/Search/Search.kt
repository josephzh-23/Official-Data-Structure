package Search

class Search {
    fun linearSearch(array: IntArray, target: Int): Int {
        for (i in array.indices) if (array[i] == target) return i
        return -1
    }

    fun binarySearchRec(array: IntArray, target: Int): Int {
        return binarySearchRec(array, target, 0, array.size - 1)
    }

    // Will return the index of the item you are trying to find
    private fun binarySearchRec(
        array: IntArray, target: Int, left: Int, right: Int
    ): Int {
        if (right < left) // Base condition that means empty partition now
            return -1
        val middle = (left + right) / 2
        if (array[middle] == target) return middle

        // THis means the target is in the left partition
        return if (target < array[middle]) binarySearchRec(array, target, left, middle - 1) else binarySearchRec(
            array,
            target,
            middle + 1,
            right
        )

        // Otherwise in the right partitino
    }

    // Using the iterative approach
    fun binarySearch(array: IntArray, target: Int): Int {
        var left = 0
        var right = array.size - 1
        while (left <= right) {
            val middle = (left + right) / 2
            if (array[middle] == target) return middle
            if (target < array[middle]) // UPdate the right pointer if in the left partition
                right = middle - 1 else  // Otherwise update the left pointer
                left = middle + 1
        }

        /*
     When get tot here, means the target is not in the
     divided array
     */return -1
    }

    fun ternarySearch(array: IntArray, target: Int): Int {
        return ternarySearch(array, target, 0, array.size - 1)
    }

    // Little slower than binary search as discussed before
    private fun ternarySearch(
        array: IntArray, target: Int, left: Int, right: Int
    ): Int {

        // The base conditino here
        if (left > right) return -1
        val partitionSize = (right - left) / 3
        val mid1 = left + partitionSize
        val mid2 = right - partitionSize
        if (array[mid1] == target) return mid1
        if (array[mid2] == target) return mid2

        // If in the left partition
        if (target < array[mid1]) return ternarySearch(array, target, left, mid1 - 1)

        // In right partition
        return if (target > array[mid2]) ternarySearch(array, target, mid2 + 1, right) else ternarySearch(
            array,
            target,
            mid1 + 1,
            mid2 - 1
        )

        // In the middle partion [ mid1 +1,  mid2 -1]
    }

    fun jumpSearch(array: IntArray, target: Int): Int {
        val blockSize = Math.sqrt(array.size.toDouble()).toInt()

        // Get the pointer here
        var start = 0
        var next = blockSize
        // Here find potential block where the item existed

        // next: the stating index of next block,
        // next -1 : the ending index of the cur block
        while (start < array.size &&
            array[next - 1] < target
        ) {

            /*
      Advacne the pointer
       */
            start = next
            next += blockSize

            /*
      If next gets too big, reduce it to size of array
       */if (next > array.size) next = array.size
        }

        /*
    If we do find a block to search for target value
    then go ahead with following
     */for (i in start until next) if (array[i] == target) return i
        return -1
    }

    fun exponentialSearch(
        array: IntArray, target: Int
    ): Int {
        var bound = 1

        /*
        Double the bound as indicated if cur
        val < target val
         */
        while (bound < array.size &&
            array[bound] < target
        ) bound *= 2
        val left = bound / 2

        // Pick the min of the array.size -1
        val right = Math.min(bound, array.size - 1)
        return binarySearchRec(array, target, left, right)
    }
}