package Hashtables

import java.util.*


/*
Dictionary : [key, entries]
    key: some hashed value
   entries: arrayOf<LinkedList<Entry>>()   aka a bucket

   - a bucket will have a bunch [key, linkedList<Entry>]
        each entry will correspond with a unique key
 */
class HashTable {
    private inner class Entry(val key: Int, var value: String)

    // aka the bucket of the program
    private val entries = arrayOfNulls<LinkedList<Entry>>(5)

    // Here we will use chaining
    // use an linkedlist ->
    fun put(key: Int, value: String) {

        /*
        here to avoid duplicate key
       1.
        - will loop thru all entries; if find entry
        with same key, update the key's value

        2. Otherwisem
        add entry to end of list
         */
        val entry = getEntry(key)
        if (entry != null) {
            entry.value = value
            return
        }
        /*
        If we don't find an entry with same
        keym add key to bucket
         */
        getOrCreateBucket(key)!!.add(Entry(key, value))
    }


    operator fun get(key: Int): String? {

        /*

         */
        val entry = getEntry(key)
        return entry?.value
    }

    fun remove(key: Int) {
        val entry = getEntry(key) ?: throw IllegalStateException()
        getBucket(key)!!.remove(entry)
    }



    private fun getBucket(key: Int): LinkedList<Entry> {

        /*
        Use hash to find where we have stored key-pair value

         */
        return entries[hash(key)]!!
    }

    private fun getOrCreateBucket(key: Int): LinkedList<Entry>{
        val index = hash(key)
        val bucket = entries[index]
        if (bucket == null) entries[index] =LinkedList<Entry>()
        return bucket!!
    }

    private fun getEntry(key: Int): Entry? {

        val bucket = getBucket(key)
        /*
        Here we iterate over this bucket (array<LinkedList<Entry>>
        If we find an entry with same key
        - return its value
         */

        if (bucket != null) {
            for (entry in bucket) {
                /*
                If we find an entry with same key
                - return the entry, otherwise no such entry
                 */
                if (entry.key == key) return entry
            }
        }
        return null
    }

    // This will ensure whatever key we have
    // we reduce it to size of array
    private fun hash(key: Int): Int {
        return key % entries.size
    }
}
