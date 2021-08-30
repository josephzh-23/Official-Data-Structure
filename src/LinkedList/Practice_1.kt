package LinkedList

// Problem 1: Reverse a linkedlist from scratch
fun main (){

    // testing things out
    var node = ListNode(4)
    var nextnode = ListNode(5)

    node.next= nextnode

    var head = reverseList(node)
    print(head?.value)
}
// Reverse a linkedlist from scratch no problem
fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr: ListNode? = head
    while (curr != null) {
        val nextTemp: ListNode? = curr.next
        curr.next = prev
        prev = curr
        curr = nextTemp
    }
    return prev
}