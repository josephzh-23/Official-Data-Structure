package Sorting

import java.util.*


class BucketSort {
    fun sort(array: IntArray, numberOfBuckets: Int) {
        var i = 0
        for (bucket in createBuckets(array, numberOfBuckets)) {
            Collections.sort(bucket)
            for (item in bucket) array[i++] = item
        }
    }

    private fun createBuckets(array: IntArray, numberOfBuckets: Int): List<MutableList<Int>> {
        val buckets: MutableList<MutableList<Int>> = ArrayList()

        for (i in 0 until numberOfBuckets) buckets.add(ArrayList())

        for (item in array) buckets[item / numberOfBuckets].add(item)
        return buckets
    }
}
