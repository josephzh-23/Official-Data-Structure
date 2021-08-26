package Queue

import java.util.*

fun main(args:Array<String>){

    // Basic array Queue
    var queue = ArrayQueue(5)
    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)
    queue.enqueue(40)
    queue.enqueue(50)
    queue.enqueue(10)
    queue.enqueue(10)

    println(queue)

    // Queueu using stacks
    var queue2 = QueueWithTwoStacks()
    queue2.enqueue(10)
    queue2.enqueue(20)
    queue2.enqueue(30)
    var first = queue2.dequeue()

    println("queue with sacks ${first}")

    // Using priority queue
    var queue3 = PriorityQueue()
    queue3.add(5)
    queue3.add(3)
    println(queue3)
}