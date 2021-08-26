package Hashtables

fun main (){
    val map = HashMap<Int, String>()

    map.put(123456, "Code")
    println(hash(123456))



}
fun hash(number:Int):Int{

    return number%100
}





