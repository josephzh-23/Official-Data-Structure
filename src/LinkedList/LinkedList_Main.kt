package LinkedList

fun main(args:Array<String>){

     var root =Node(4)
    var root2 =Node(4)

      root= addFirst(root, 5)
     root = addFirst(root, 6)
//    root = removeFirst(root)

    var res = removeLastNode(root)
    printList(res)


    print(root)
        var list = LinkedList()
    // Insert in the middle

        list.addLast(1)
        list.addLast(2)
        list.reverse()
//    println("the list is" +list.printList())



//    list.reverse()
////        var array = list.toArray()
//        println("array is "+ Arrays.toString(list.toArray()))

//    println("get kth node  "+ list.indexOf(1))

//    println("get kth node  "+ list.printMiddle())

    // Used to remove the kth node
//    var node = list.removeKthNodeFromEnd(3)
//    println("get kth node  "+node.value)


}








