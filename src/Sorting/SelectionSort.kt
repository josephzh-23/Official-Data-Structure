package Sorting

class SelectionSort {
    fun sort(array: IntArray) {
        for (i in array.indices) {
            var minIndex = i

            // Start at j = i, where we swapped the previous time
            for (j in i until array.size) if (array[j] < array[minIndex])
                // minIndex: index of the next smallest item as discussed.
                minIndex = j
            swap(array, minIndex, i)
        }
    }

    private fun swap(array: IntArray, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}
