package LinkedList


class Practice_2 {
}

// Check if the linkedlist has a cycle
fun main (){

    var node = ListNode(4)
    var node2 = ListNode(4)
    var node3 = ListNode(4)


   node.next = node2
    node2.next = node3
//    node3.next = node
    var res = hasCycle(node)
    print(res)
}

fun hasCycle(head: ListNode?): Boolean {
    var head = head
    val existingNodes: MutableSet<ListNode> = HashSet()
    while (head != null) {
        if (existingNodes.contains(head)) {
            return true
        }
        existingNodes.add(head)

        // keep traversing
        head = head.next
    }
    return false
}