package com.codewithmosh

import java.util.*

// Implemented stack using an int array here
class Stack {
  private val items = IntArray(5)
  private var count = 0
  fun push(item: Int) {
    if (count == items.size) throw StackOverflowError()
    items[count++] = item
  }

  fun pop(): Int {
    check(count != 0)
    return items[--count]
  }

  fun peek(): Int {
    check(count != 0)
    return items[count - 1]
  }

  val isEmpty: Boolean
    get() = count == 0

  override fun toString(): String {
    val content = Arrays.copyOfRange(items, 0, count)
    return Arrays.toString(content)
  }
}