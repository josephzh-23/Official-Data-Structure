package Trie


class Trie {

  // Each node will have a bunch of children

  private inner class Node(val value: Char) {

    // "s"  ->
    private val children = HashMap<Char, Node>()
    var isEndOfWord = false
    override fun toString(): String {
      return "value=$value"
    }

    fun hasChild(ch: Char): Boolean {
      return children.containsKey(ch)
    }

    fun addChild(ch: Char) {
      children[ch] = Node(ch)
    }

    // Get the child in the children based on the key
    fun getChild(ch: Char): Node? {
      return children[ch]
    }

    fun getChildren(): Array<Node> {
      return children.values.toTypedArray()
    }

    fun hasChildren(): Boolean {
      return !children.isEmpty()
    }

    fun removeChild(ch: Char) {
      children.remove(ch)
    }
  }

  private val root: Node = Node(' ')


  fun insert(word: String) {
    var current: Node? = root

    // Word is "char"
    for (ch in word.toCharArray()) {
      if (!current!!.hasChild(ch)) current.addChild(ch)
      current = current.getChild(ch)
    }
    // When we reach the end of the word
    current!!.isEndOfWord = true
  }

  operator fun contains(word: String?): Boolean {
    if (word == null) return false
    var current: Node? = root
    for (ch in word.toCharArray()) {
      if (!current!!.hasChild(ch)) return false

      // Set current to pint to child
      current = current.getChild(ch)
    }

    // Make sure current has the isEndOF word property
    return current!!.isEndOfWord
  }

  fun traverse() {
    traverse(root)
  }

  private fun traverse(root: Node) {
    for (child in root.getChildren()) traverse(child)

    // Post-order: visit the root last
    println(root.value)
  }

  private fun traverse_PreOrder(root:Node){
    // Pre-order: visit the root first
    println(root.value)
    for (child in root.getChildren()) traverse(child)


  }



  fun remove(word: String?) {
    if (word == null) return
    remove(root, word, 0)
  }

  private fun remove(root: Node, word: String, index: Int) {

    // Base condition
    // That means we have reached end of whe word
    if (index == word.length) {
      root.isEndOfWord = false
      return
    }
    val ch = word[index]
    val child = root.getChild(ch) ?: return
    remove(child, word, index + 1)

    if (!child.hasChildren() && !child.isEndOfWord) root.removeChild(ch)
  }

  fun findWords(prefix: String): List<String> {
    val words: MutableList<String> = ArrayList()
    val lastNode = findLastNodeOf(prefix)
    findWords(lastNode, prefix, words)
    return words
  }

  private fun findWords(root: Node?, prefix: String, words: MutableList<String>) {
    if (root == null) return
    if (root.isEndOfWord) words.add(prefix)
    for (child in root.getChildren()) findWords(child, prefix + child.value, words)
  }

  private fun findLastNodeOf(prefix: String?): Node? {
    if (prefix == null) return null
    var current = root
    for (ch in prefix.toCharArray()) {
      val child = current.getChild(ch) ?: return null
      current = child
    }
    return current
  }

  fun containsRecursive(word: String?): Boolean {
    return if (word == null) false else containsRecursive(root, word, 0)
  }

  private fun containsRecursive(root: Node?, word: String, index: Int): Boolean {
    // Base condition
    if (index == word.length) return root!!.isEndOfWord
    if (root == null) return false
    val ch = word[index]
    val child = root.getChild(ch) ?: return false
    return containsRecursive(child, word, index + 1)
  }

  fun countWords(): Int {
    return countWords(root)
  }

  private fun countWords(root: Node): Int {
    var total = 0
    if (root.isEndOfWord) total++
    for (child in root.getChildren()) total += countWords(child)
    return total
  }

  fun printWords() {
    printWords(root, "")
  }

  private fun printWords(root: Node, word: String) {
    if (root.isEndOfWord) println(word)
    for (child in root.getChildren()) printWords(child, word + child.value)
  }

  companion object {
    var ALPHABET_SIZE = 26

    // We add these words to a trie and walk down
    // the trie. If a node has more than one child,
    // that's where these words deviate. Try this
    // with "can", "canada", "care" and "cab". You'll
    // see that these words deviate after "ca".
    //
    // So, we keep walking down the tree as long as
    // the current node has only one child.
    //


    // One edge cases we need to count is when two
    // words are in the same branch and don't deviate.
    // For example "can" and "canada". In this case,
    // we keep walking down to the end because every
    // node (except the last node) has only one child.
    // But the longest common prefix here should be
    // "can", not "canada". So, we should find the
    // shortest word in the list first. The maximum
    // number of characters we can include in the
    // prefix should be equal to the length of the
    // shortest word.
    fun longestCommonPrefix(words: Array<String>?): String {
      if (words == null) return ""
      val trie = Trie()
      for (word in words) trie.insert(word)
      val prefix = StringBuffer()
      val maxChars = getShortest(words).length
      var current = trie.root
      while (prefix.length < maxChars) {
        val children = current.getChildren()
        if (children.size != 1) break
        current = children[0]
        prefix.append(current.value)
      }
      return prefix.toString()
    }

    private fun getShortest(words: Array<String>?): String {
      if (words == null || words.size == 0) return ""
      var shortest = words[0]
      for (i in 1 until words.size) {
        if (words[i].length < shortest.length) shortest = words[i]
      }
      return shortest
    }
  }
}
