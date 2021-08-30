package LinkedList

class LinkedList {
    inner class Node(val value: Int) {
        var next: Node? = null
    }

     var first: Node? = null
   var last: Node? = null
    var size = 0

    fun addLast(item: Int) {
        // Here the node.next -> null automatically when
        // created
        val node: Node = Node(item)
        if (isEmpty) {
            last = node
            first = last
        } else {


            last!!.next = node
            // Note here node.next = null here
            last = node
        }
        size++
    }


 fun printList(){

     var cur = first

     // While not the last element

     while(cur!=null) {
         print(" ${cur!!.value}")
         cur = cur!!.next
     }
 }


    fun insertAfter (prevNode: Node, item: Int){

        /* 1. Check if the given Node is null */
        if (prevNode == null)
        {
            System.out.println("The given previous node cannot be null");
            return;
        }

        val node = Node(item)
        node.next = prevNode

        prevNode.next = node
    }
    fun addFirst(item: Int) {
        val node: Node = Node(item)
        if (isEmpty) {
            last = node
            first = last
        } else {
            node.next = first
            first = node
        }
        size++
    }

    private val isEmpty: Boolean
        private get() = first == null

    fun indexOf(item: Int): Int {
        var index = 0
        var current = first
        while (current != null) {
            if (current.value == item) return index
            current = current.next
            index++
        }
        return -1
    }

    operator fun contains(item: Int): Boolean {
        return indexOf(item) != -1
    }

    fun removeFirst() {
        if (isEmpty) throw NoSuchElementException()
        if (first === last) {
            last = null
            first = last
        } else {
            val second = first!!.next
            first!!.next = null
            first = second
        }
        size--
    }

    fun removeKthNodeFromEnd( k: Int): Node {

        check(!isEmpty)
        var a = first
        var b = first

        // Move 2nd pter forward
        // until a and b are k-1 apart
        for (i in 0 until k - 1) {
            b = b!!.next

            // If b is null, k > size of linkedlist
            requireNotNull(b)
        }

        // Keep moveing forward
        while (b !== last) {
            a = a!!.next
            b = b!!.next
        }

        // a now points at the kth node we want to remove
        a!!.next = a.next?.next
        return a
    }
    fun removeLast() {
        if (isEmpty) throw NoSuchElementException()
        if (first === last) {
            last = null
            first = last
        } else {
            val previous = getPrevious(last)
            last = previous
            last!!.next = null
        }
        size--
    }

    private fun getPrevious(node: Node?): Node? {
        var current = first
        while (current != null) {
            if (current.next === node) return current
            current = current.next
        }
        return null
    }

    fun size(): Int {
        return size
    }

    fun toArray(): IntArray {
        val array = IntArray(size)
        var current = first
        var index = 0

        // Add current node to array
        /*
        1. Set current to reference the next node
         */
        while (current != null) {
            array[index++] = current.value

          //  1. Set current to reference the next node
            current = current.next
        }
        return array
    }



    fun reverse() {
        if (isEmpty) return

        // Make the preiovus first first before anything else
        var previous = first
        var current = first!!.next
        while (current != null) {
            val next = current.next

            // Reverse diretion here
            current.next = previous
            previous = current
            current = next
        }
        last = first
        last!!.next = null
        first = previous
    }


    fun getKthFromTheEnd(k: Int): Int {
        check(!isEmpty)
        var a = first
        var b = first

        // Move 2nd pter forward
        // until they are 2 distances apart
        for (i in 0 until k - 1) {
            b = b!!.next

            // If b is null, k > size of linkedlist
            requireNotNull(b)
        }

        // Keep moveing forward
        while (b !== last) {
            a = a!!.next
            b = b!!.next
        }
        return a!!.value
    }



    fun printMiddle() {
        check(!isEmpty)
        var a = first
        var b = first
        while (b !== last && b!!.next !== last) {
            b = b!!.next!!.next
            a = a!!.next
        }
        if (b === last) println(a!!.value) else println(a!!.value.toString() + ", " + a.next!!.value)
    }




    fun hasLoop(): Boolean {
        var slow = first
        var fast = first
        while (fast != null && fast.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
            if (slow === fast) return true
        }
        return false
    }

    companion object {
        fun createWithLoop(): LinkedList {
            val list = LinkedList()
            list.addLast(10)
            list.addLast(20)
            list.addLast(30)

            // Get a reference to 30
            val node = list.last
            list.addLast(40)
            list.addLast(50)

            // Create the loop
            list.last!!.next = node
            return list
        }
    }
}