package LinkedList

// add 2 numbers usign linkedlist reversed

object LinkedListApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val a = Linked()
        var head1: Node? = null
        head1 = a.insert(1, head1)
        head1 = a.insert(7, head1)
        head1 = a.insert(8, head1)
        head1 = a.insert(2, head1)
        head1 = a.insert(5, head1)
        a.printList(head1)
        println()

        var head2: Node? = null
        head2 = a.insert(5, head2)
        head2 = a.insert(6, head2)
        head2 = a.insert(7, head2)
        a.printList(head2)
        println()


        val addLists = a.addTwoNumbers(head1, head2)
        a.printList(addLists)
    }
}


internal class Linked {

    fun addTwoNumbers(node1: Node?, node2: Node?): Node? {

        // These r the 2 root nodes
        var node1 = node1
        var node2 = node2


//        node1 = this.our_reverse(node1)
//        node2 = this.our_reverse(node2)

//         These 2 have been reversed
        node1 =this.our_reverse(node1)
        node2= this.our_reverse(node2)

        // prev here acts as a temp holder for newListHead
        // which is really useful
        var newHead: Node? = null
        var temp: Node? = null
        var sum: Int

        // the carry
        var c = 0

        while (node1 != null || node2 != null) {
            sum = (c + (node1?.value ?: 0)
                    + (node2?.value ?: 0))


            c = sum / 10

            val node = Node(sum % 10)

            // If this is the first node
            if (newHead == null) {
                newHead = node

                // For next nodes
            } else {
               temp!!.next = node
            }


            temp = node
            if (node1 != null) {
                node1 = node1.next
            }
            if (node2 != null) {
                node2 = node2.next
            }
        }
        // if there is a carry of 1 at the end
        if (c != 0) {
            temp!!.next =Node(c)
        }
        newHead = this.reverse(newHead)
        return newHead
    }

    /*
   * It reverses the linked list
   */


    /*
   * getNewNode() method to generate a new node
   */
    fun getNewNode(key: Int): Node {
        val a = Node()
        a.next = null
        a.value = key
        return a
    }

    /*
   * insert method is used to insert the element in Linked List
   */
    fun insert(key: Int, node: Node?): Node {

        if (node == null) return getNewNode(key)
        else {
            // if node already exists
            node.next = insert(key, node.next)
        }
        return node
    }


    /*
   * It'll print the complete linked list
   */
    fun printList(node: Node?) {
        if (node == null) {
            return
        }
        print(node.value.toString() + " ")
        printList(node.next)
    }
    fun reverse(node: Node?): Node? {

        // The temp returned is
        if (node == null || node.next == null) {
            return node
        }
        val temp = reverse(node.next)
        node.next!!.next = node
        node.next = null

        return temp

    }
    /*
    The node here is the root
    return : the new head of the linkedlist
     */
    fun our_reverse(node: Node?): Node? {

        // prev would eventually end up as the head
        var prev:Node? = node
        var current = node!!.next

        var next:Node?=null
        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next

        }

        var last: Node? = node
        last?.next = null
//        prev?.next = null

        return prev
//        print("temp value is" +current!!.value)




    }

}

