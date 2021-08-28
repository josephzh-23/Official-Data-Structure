import java.util.*

fun main(args:Array<String>){
        var list = LinkedList()
    // Insert in the middle

        list.addLast(1)
        list.addLast(2)
    println("the list is" +list.printList())
    list.insertAfter(list.first!!, 3)

    list.addLast(2)

    print("size of the list is "+ list.size)

//    list.reverse()
////        var array = list.toArray()
//        println("array is "+ Arrays.toString(list.toArray()))

    println("this is "+ list.indexOf(1))
//    println("get kth node  "+ list.indexOf(1))

//    println("get kth node  "+ list.printMiddle())

    // Used to remove the kth node
    var node = list.removeKthNodeFromEnd(3)
//    println("get kth node  "+node.value)


}








