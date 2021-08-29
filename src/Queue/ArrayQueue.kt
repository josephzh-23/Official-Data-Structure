package Queue

import java.util.*


/*
When Enqueue
1. must keep 2 pters
the front and rear
 */
class ArrayQueue(capacity: Int) {
  private val items: IntArray

  // Rear pter to last elem in the queue
  private var rear = 0
  private var front = 0

  // Count # of item in an array
  private var count = 0

  // When we enqueue -> must increase the rear pter
  fun enqueue(item: Int) {
    check(!isFull)
    items[rear] = item

    // THis is the circular array
    rear = (rear + 1) % items.size

  }

  fun dequeue(): Int {
    check(!isEmpty)

    val item = items[front]
    items[front] = 0


    front = (front + 1) % items.size
    count--
    return item
  }

  fun peek(): Int {
    check(!isEmpty)
    return items[front]
  }

  val isEmpty: Boolean
    get() = count == 0
  val isFull: Boolean
    get() = count == items.size

  override fun toString(): String {
    return Arrays.toString(items)
  }

  init {
    items = IntArray(capacity)
  }
}
