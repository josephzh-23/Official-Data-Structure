package Queue

import java.util.*


// Will be moving between stack 1 to stack 2 if stack 1 empty

class QueueWithTwoStacks {
     val stack1 = Stack<Int>()
     val stack2 = Stack<Int>()

    // O(1)
    fun enqueue(item: Int) {
        stack1.push(item)
    }

    // O(n)
    fun dequeue(): Int {
        check(!isEmpty)
        moveStack1ToStack2()
        return stack2.pop()
    }

    private fun moveStack1ToStack2() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty()) stack2.push(stack1.pop())
    }

    fun peek(): Int {
        check(!isEmpty)
        moveStack1ToStack2()
        return stack2.peek()
    }

    val isEmpty: Boolean
        get() = stack1.isEmpty() && stack2.isEmpty()
}
