package Search

fun main(){

    var numbers = intArrayOf (1, 3,5,6, 7)

    var search = Search()
//    var index = search.jumpSearch(numbers, 3)

    var index = search.exponentialSearch(numbers, 4)
    println(index)
}