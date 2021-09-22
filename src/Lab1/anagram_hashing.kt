package Lab1

import java.util.*

var NO_OF_CHARS = 256
fun areAnagrams_hashing(str1: CharArray, str2: CharArray):Boolean{

    // For each character in input strings, increment count
    // in the corresponding count array
    // Create 2 count arrays and initialize
    // all values as 0
    val count1 = IntArray(NO_OF_CHARS)
    Arrays.fill(count1, 0)
    val count2 = IntArray(NO_OF_CHARS)
    Arrays.fill(count2, 0)


    var i = 0
    // For each character, add to the count array
    while (i < str1.size && i < str2.size) {
       count1[str1[i].toInt()]++
        count2[str1[i].toInt()]++
        i++
    }

    //And then iterate thru the whole array to make sure that str 1 and 2
    // are same length
    for (i in 0..NO_OF_CHARS){

        if(count1[i]!=count2[i]){

            return false
        }
    }
    return true

}
//
//fun areAnagram(str1: CharArray, str2: CharArray): Boolean {
//
//    var i: Int
//
//    // For each character in input strings,
//    // increment count in the corresponding
//    // count array
//    i = 0
//    while (i < str1.size && i < str2.size) {
//        count1[str1[i].toInt()]++
//        count2[str2[i].toInt()]++
//        i++
//    }
//
//    // If both strings are of different length.
//    // Removing this condition will make the program
//    // fail for strings like "aaca" and "aca"
//    if (str1.size != str2.size) return false
//
//    // Compare count arrays
//    i = 0
//    while (i < NO_OF_CHARS) {
//        if (count1[i] != count2[i]) return false
//        i++
//    }
//    return true
//}






