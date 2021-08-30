package Sorting

import java.util.*

fun main(){

    var numbers = intArrayOf(7, 3, 1, 4, 6, 2, 3)
    var sorter = BubbleSort()
//    sorter.sort(numbers)
//    println(Arrays.toString(numbers))


//    var sorter2 = CountSort()
//    sorter2.sort(numbers, 7)
//    println(Arrays.toString(numbers))

    var sorter3 = BucketSort()
    sorter3.sort(numbers, 3)
    println(Arrays.toString(numbers))

}
