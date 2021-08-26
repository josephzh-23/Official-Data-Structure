package Stacks

import java.util.*


// Compare opening and closing bracket here

class Expression {

    private val leftBrackets = Arrays.asList('(', '<', '[', '{')

    private val rightBrackets = Arrays.asList(')', '>', ']', '}')


    fun isBalanced(input: String): Boolean {
        val stack = Stack<Char>()
        for (ch in input.toCharArray()) {

            if (isLeftBracket(ch)) stack.push(ch)

            if (isRightBracket(ch)) {
                if (stack.empty()) return false
                val top = stack.pop()
                if (!bracketsMatch(top, ch)) return false
            }
        }
        return stack.empty()
    }

    private fun isLeftBracket(ch: Char): Boolean {
        return leftBrackets.contains(ch)
    }

    private fun isRightBracket(ch: Char): Boolean {
        return rightBrackets.contains(ch)
    }

    private fun bracketsMatch(left: Char, right: Char): Boolean {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right)
    }
}
