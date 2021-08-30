package LinkedList

// To be used everywhere here
class Node(var value: Int = 0) {
    var next: Node? = null

}

// Here the node.next -> null automatically when
// created
// Same as add last
fun insert(key: Int, node: Node?): Node {

    if (node == null) return getNewNode(key)
    else {
        // if node already exists
        node.next = insert(key, node.next)
    }
    return node
}

fun getNewNode(key: Int): Node {
    val a = Node()
    a.next = null
    a.value = key
    return a
}

// need to return the modified head
fun addFirst(head: Node, value:Int):Node{

    val node = Node(value)

    node.next =head
    var modifiedHead =node
    return modifiedHead
}


fun printList(node: Node?) {
    if (node == null) {
        return
    }
    print(node.value.toString() + " ")
    printList(node.next)
}

fun removeFirst(root: Node) : Node {

    // Hold temp variable
        val second = root!!.next
       root!!.next = null
       var newRoot = second
        return newRoot!!
}



fun getPrevious(node:Node?): Node? {
    var current = node
    while (current != null) {
        if (current.next === node) return current
        current = current.next
    }
    return null
}

fun removeLastNode(first: Node?): Node? {
    if (first == null) return null
    if (first.next == null) {
        return null
    }

    var second_last = first
    while (second_last!!.next!!.next != null) second_last = second_last.next

    // Change next of second last
    second_last.next = null
    return first
}
