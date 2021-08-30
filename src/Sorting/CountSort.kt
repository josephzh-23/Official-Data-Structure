package Sorting

class CountSort {
    // Max is the max of the array
    fun sort(array: IntArray, max: Int) {

        // Counts will have sth like  at position 1, # of counts for 1
        // at position 1: # of counts for 1
        val counts = IntArray(max + 1)
        // Increase the count variable s

        // We use this item as an index in the count array
        for (item in array) counts[item]++

        // Here refill the input array in a sorted manner
        // k will be an indexer for the input array
        var k = 0

        for (i in counts.indices)

        // ex; if we have 3 threes
            for (j in 0 until counts[i]) {
                array[k] = i
                k++
            }
    }
}
