package Queue

import java.util.*


object QueueReverser {

// Remove item from queeu and put it in stack
    // then remove stuff from stack and put it back in queue
    fun reverse(queue: Queue<Int?>, k: Int) {
        require(!(k < 0 || k > queue.size))

        val stack: Stack<Int?> = Stack()

        // Dequeue the first K elements from the queue
        // and push them onto the stack
        for (i in 0 until k) stack.push(queue.remove())

        // Enqueue the content of the stack at the
        // back of the queue
        while (!stack.empty()) queue.add(stack.pop())

        // Add the remaining items in the queue (items
        // after the first K elements) to the back of the
        // queue and remove them from the beginning of the queue
        for (i in 0 until queue.size - k) queue.add(queue.remove())
    }
}