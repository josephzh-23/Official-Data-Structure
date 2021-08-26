import java.util.*

fun main(args:Array<String>){
        var list = LinkedList()

        list.addLast(1)
        list.addLast(2)

    list.addLast(2)
//    list.reverse()
////        var array = list.toArray()
//        println("array is "+ Arrays.toString(list.toArray()))

    println("this is "+ list.indexOf(1))
    println("get kth node  "+ list.indexOf(1))

    println("get kth node  "+ list.printMiddle())

}








