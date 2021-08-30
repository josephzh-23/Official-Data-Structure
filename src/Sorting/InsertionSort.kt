package Sorting

class InsertionSort {
    fun sort(array: IntArray) {
        for (i in 1 until array.size) {
            val current = array[i]

            // j is the previous item
            var j = i - 1

            // This loop look at all preivous item
            // If they are greater, shfit them to the right
            while (j >= 0 && array[j] > current) {

                // Copy item at that position to the right
                array[j + 1] = array[j]
                j--
            }
            array[j + 1] = current
        }
    }
}
