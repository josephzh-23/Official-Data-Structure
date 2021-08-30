package LinkedList

fun main(){

    val list =LinkedList_Test()
    list.first = LinkedList_Test.Node(85)
    list.first?.next = LinkedList_Test.Node(15)
    list.first?.next?.next = LinkedList_Test.Node(4)
    list.first?.next?.next?.next = LinkedList_Test.Node(20)

    System.out.println("Given Linked list");
    list.printList(list.first);
    var head = list.reverse(list.first)
    System.out.println("Reversed linked list ");
    list.printList(head);
}


// Tested out above
class LinkedList_Test{
   class Node(val value: Int) {
        var next: Node? = null
    }

    var first: Node? = null
    var last: Node? = null
    var size = 0

    /* Function to reverse the linked list */
    fun reverse(node: Node?): Node? {

        // Set 3 pointers here
        var prev: Node? = first
        var current = first!!.next


        while (current != null) {
            var next = current.next
            current.next = prev
            prev = current
            current = next
        }
        last = first
        last!!.next =null
         first = prev


        return first
    }


    // prints content of double linked list
    fun printList(node: Node?) {
        var node = node
        while (node != null) {
            print(node.value.toString() + " ")
            node = node.next
        }
    }
}