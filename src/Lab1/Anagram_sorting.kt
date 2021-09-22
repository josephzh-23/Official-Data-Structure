package Lab1

import java.util.*


fun main(){

    val str1 = charArrayOf('t', 'e', 's', 't')
    val str2 = charArrayOf('t', 't', 'e', 'w')


    print(areAnagrams(str1, str2))
}




    fun areAnagrams(str1: CharArray, str2: CharArray):Boolean{

        var len1 = str1.size
        var len2 = str2.size

        Arrays.sort(str1)
        Arrays.sort(str2)

        // Compare sorted arrays
        for(i in 0..str1.size){

            if(str1[i]!=str2[i]){
                return false
            }
        }

        return true

    }


