package Sorting

class QuickSort {
    fun sort(array: IntArray) {
        sort(array, 0, array.size - 1)
    }

    // Start and end tell you what part of this array we are tying to sort
    // these indexes will then ty to change
    /* Ex:
      0, 9
      4 pivot
      0, 3 (left)     5, 9 (right)
   */
    private fun sort(array: IntArray, start: Int, end: Int) {

        // Base condition: when we have a single item array
        // or when start> end (empty array)
        if (start >= end) return

        // Boundary is the positino of the pivot
        val boundary = partition(array, start, end)

        // if boundary = 4,  0, 3 (left)     5, 9 (right)
        // Will keep traversing until it reaches the end
        sort(array, start, boundary - 1)
        sort(array, boundary + 1, end)
    }

    /*
   return : index of pivot after it has moved to its correct position
    usually pivot start at the end
   */
    private fun partition(array: IntArray, start: Int, end: Int): Int {
        val pivot = array[end]

        // If index we r looking at starts at 3, boundary =2
        var boundary = start - 1
        for (i in start..end)  // Here if we find a smaller item, then put it
        // in the left partition
            if (array[i] <= pivot) swap(array, i, ++boundary)

        // This would be position of pivot after it has moved
        return boundary
    }

    private fun swap(array: IntArray, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}
