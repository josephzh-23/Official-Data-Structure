package Sorting


class MergeSort {
    fun sort(array: IntArray) {

        // Diviide array into half
        // ANd find the middle first

        // Base condition: when an array with a
        // single item, the job is done here
        if (array.size < 2) return
        val middle = array.size / 2
        val left = IntArray(middle)

        // COpy item into the left partition from org array
        for (i in 0 until middle) left[i] = array[i]
        val right = IntArray(array.size - middle)

        // COpy item into the right partition from org array
        for (i in middle until array.size)  // Caclulate the right index
            right[i - middle] = array[i]
        sort(left)
        sort(right)
        merge(left, right, array)
    }

    private fun merge(left: IntArray, right: IntArray, result: IntArray) {

        // i for iterating over left partition
        // j for iterating over right partition

        // k to iterate over result array
        var i = 0
        var j = 0
        var k = 0
        while (i < left.size && j < right.size) {

            // Copy item from left position into this array
            if (left[i] <= right[j]) result[k++] = left[i++] else result[k++] = right[j++]
        }
        /*
    if left arr has more items than right arr, or vice versa
    need to copy remaining items from the left or the right array
    into the resulting array
*/
        while (i < left.size) result[k++] = left[i++]
        while (j < right.size) result[k++] = right[j++]
    }
}
