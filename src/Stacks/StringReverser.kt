package Stacks

import java.util.*

class StringReverser {
    fun reverse(input: String?): String {
        requireNotNull(input)


        val stack = Stack<Char>()
        for (ch in input.toCharArray()) stack.push(ch)
        val reversed = StringBuffer()

        while (!stack.empty()) reversed.append(stack.pop())
        return reversed.toString()
    }
}