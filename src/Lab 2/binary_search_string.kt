package `Lab 2`

fun binary_search_string(str: ArrayList<String>, x: String):Int{


    // Implement this using this
    var len = str.length
    var l = 0

    var r =len -1

    while(l <= r){
        val m = l + (r-l)/2


        val res = x.compareTo(str[m])
        if(res==0) {
            return m


       if(res >0){

       }


        }
    }
}















