package Queue

import java.util.*
/*
For priority queue, we always iterate form the back
 */

class PriorityQueue {
    private val items = IntArray(5)

    // Count the size of the queue
    private var count = 0

    // O(n)
    fun add(item: Int) {
        check(!isFull)
        val i = shfit_Items_To_Insert(item)
        items[i] = item
        count++
    }

    val isFull: Boolean
        get() = count == items.size

    // Check the item we would like to insert
    // Return the position of where the insert can happen
    private fun shfit_Items_To_Insert(item: Int): Int {
        var i: Int
        i = count - 1
        while (i >= 0) {

            // copy the item to the right here 
            if (items[i] > item) {
                items[i + 1] = items[i]
            }
            else break
            i--
        }
        return i + 1
    }

    // O(1)
    fun remove(): Int {
        check(!isEmpty)
        return items[--count]
    }

    val isEmpty: Boolean
        get() = count == 0

    override fun toString(): String {
        return Arrays.toString(items)
    }
}



