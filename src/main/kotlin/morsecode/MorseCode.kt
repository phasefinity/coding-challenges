package morsecode

object MorseCode {
    /** Dictionary of morse code letters  */
    private val morseDictionary = mapOf(
        "A" to "._",
        "B" to "_...",
        "C" to "_._.",
        "D" to "_..",
        "E" to ".",
        "F" to ".._.",
        "G" to "__.",
        "H" to "....",
        "I" to "..",
        "J" to ".___",
        "K" to "_._",
        "L" to "._..",
        "M" to "__",
        "N" to "_.",
        "O" to "___",
        "P" to ".__.",
        "Q" to "__._",
        "R" to "._.",
        "S" to "...",
        "T" to "_",
        "U" to ".._",
        "V" to "..._",
        "W" to ".__",
        "X" to "_.._",
        "Y" to "_.__",
        "Z" to "__..",
    )

    /** Decode the morse code into a set with all possible valid words (found in resource dictionary.txt) . */
    fun decode(morseCode: String): Set<String> {
        return emptySet()
    }
}
