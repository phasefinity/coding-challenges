package morsecode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import morsecode.MorseCode.decode

class MorseCodeTest {
    @Test
    fun `test decode morse code`() {
        assertEquals(setOf("hello"), decode("......_..._..___"))
        assertEquals(setOf("world"), decode("._____._.._.._.."))
    }

    @Test
    fun `test decode morse code with multiple combinations`() {
        assertEquals(setOf("lever", "river"), decode("._......_.._."))
    }
}
