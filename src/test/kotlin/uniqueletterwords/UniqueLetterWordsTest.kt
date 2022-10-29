package uniqueletterwords

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

private val file = object {}::class.java.classLoader.getResource("five_letter_words.txt")?.file
    ?: error("File not found")

private fun loadWords(): List<String> = File(file).readLines()

@OptIn(ExperimentalTime::class)
class UniqueLetterWordsTest {
    private val words: List<String> = loadWords()

    @Test
    fun `should find all solutions from long list of five letter words in less than 10s`() {
        val (result, duration) = measureTimedValue { findSetsOfFiveWordsWithUniqueLetters(words) }
        result.assertIsValid()

        /**
         * 25 results:
         * 1  bemix, clunk, grypt, vozhd, waqfs
         * 2  bling, jumpy, treck, vozhd, waqfs
         * 3  blonx, chawk, fritz, gyved, jumps
         * 4  blonx, fritz, gyved, jumps, whack
         * 5  blonx, fritz, gyved, jacks, whump
         * 6  blunk, cimex, grypt, vozhd, waqfs
         * 7  brick, glent, jumpy, vozhd, waqfs
         * 8  brock, judge, miltz, phynx, waqfs
         * 9  bruck, goved, miltz, phynx, waqfs
         * 10 bruck, glent, jimpy, vozhd, waqfs
         * 11 bruck, glitz, moved, phynx, waqfs
         * 12 bruck, gizmo, phynx, veldt, waqfs
         * 13 brung, kempt, vozhd, waqfs, xylic
         * 14 brung, cylix, kempt, vozhd, waqfs
         * 15 chunk, fjord, gymps, vibex, waltz
         * 16 clipt, jumby, kreng, vozhd, waqfs
         * 17 cromb, jived, klutz, phynx, waqfs
         * 18 cromb, glitz, juked, phynx, waqfs
         * 19 cromb, gived, klutz, phynx, waqfs
         * 20 crumb, glitz, joked, phynx, waqfs
         * 21 dreck, glitz, jumbo, phynx, waqfs
         * 22 fjord, glitz, phynx, quack, wembs
         * 23 fjord, gucks, nymph, vibex, waltz
         * 24 glent, jumby, prick, vozhd, waqfs
         * 25 jumby, pling, treck, vozhd, waqfs
         */
        assertEquals(
            25, result.size,
            "You did not find all possible set of words with unique letters.\n\nYour Result:\n${result.formatted}\n"
        )

        val millis = duration.inWholeMilliseconds
        assertTrue(millis <= 10_000, "findUniqueLetterWords took $millis ms... your code is too slow!")
    }

    @Test
    fun `should find all solutions from short list of five letter words`() {
        val shortList = listOf(
            "aread", "basso", "blonx", "chawk", "damna", "fjord", "fritz", "gucks", "gyved", "haoma",
            "hying", "jumps", "mohua", "nymph", "roist", "talky", "tiled", "vibex", "waltz"
        )
        val result = findSetsOfFiveWordsWithUniqueLetters(shortList)
        result.assertIsValid()

        /**
         * 2 results:
         * blonx, chawk, fritz, gyved, jumps
         * fjord, gucks, nymph, vibex, waltz
         */
        assertEquals(
            2, result.size,
            "You did not find all possible set of words with unique letters.\n\nYour Result:\n${result.formatted}\n"
        )
    }

    private fun Set<Set<String>>.assertIsValid() = forEach { setOfWords ->
        setOfWords.forEach {
            assertEquals(5, it.length, "$it does not have 5 letters")
            assertTrue(it in words, "$it is not contained in dictionary.txt")
        }
        assertEquals(5, setOfWords.size, "set of words does not contain 5 words: $setOfWords")

        val usedLetters = mutableSetOf<Char>()
        setOfWords.joinToString("").forEach {
            val isUnique = usedLetters.add(it)
            assertTrue(isUnique, "Set of words has dupplicate letter $it in $setOfWords")
        }
    }

    private val Set<Set<String>>.formatted
        get() = map { it.sorted() }.sortedBy { it.first() }.joinToString("\n") { it.joinToString() }
}