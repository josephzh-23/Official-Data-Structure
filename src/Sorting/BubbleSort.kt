package Sorting

class BubbleSort {

    fun sort(array: IntArray) {
        var isSorted: Boolean

        // First loop for first item in the array
        for (i in array.indices) {
            isSorted = true

            // 'j' is for the 2nd item in the array ,
            // COmpare the 2 items then

            /*
      THe reason for length - i, because we don't have to look at
      the item that's already sorted previously
      */
            for (j in 1 until array.size - i) if (array[j] < array[j - 1]) {
                swap(array, j, j - 1)
                isSorted = false
            }
            if (isSorted) return
        }
    }

    private fun swap(array: IntArray, index1: Int, index2: Int) {

        // Temp to hold the first and then swap here
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}
