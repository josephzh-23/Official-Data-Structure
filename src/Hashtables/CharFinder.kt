package Hashtables



fun main(){

  var finder = CharFinder()
  var ch = finder.findFirstRepeatedChar("ABCDDSF")
  println(ch)

  var ch2 = finder.findFirstNonRepeatingChar("ABCDDSF")
  println(ch2)

}
class CharFinder {


  fun findFirstNonRepeatingChar(str: String): Char {
    val map: MutableMap<Char, Int> = HashMap()
    val chars = str.toCharArray()


    for (ch in chars) {

      val count = if (map.containsKey(ch)) map[ch]!! else 0
      map[ch] = count + 1
    }

    // The non repeating character found here
    for (ch in chars) if (map[ch] == 1) return ch
    return Character.MIN_VALUE
  }

  fun findFirstRepeatedChar(str: String): Char {
    val set: MutableSet<Char> = HashSet()


    for (ch in str.toCharArray()) {

      /*
      If set already contains return
      -otherwise just add to it as mentioned
       */
      if (set.contains(ch)) return ch
      set.add(ch)
    }
    return Character.MIN_VALUE
  }
}
