package oddint

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import oddint.FindOddInt.findOddInt

class FindOddIntTest {
    @Test
    fun `easy test`() {
        // Occurrences:
        // 4 -> 2x (even)
        // 5 -> 3x (odd)
        assertEquals(5, findOddInt(intArrayOf(4, 4, 5, 5, 5)))
    }

    @Test
    fun `find odd int`() {
        assertEquals(7, findOddInt(intArrayOf(-2, 7, -9, 7, 77, -77, 4, -77, 77, 5, 7, -2, -9, 5, 4)))
        assertEquals(1, findOddInt(intArrayOf(1)))
        assertEquals(0, findOddInt(intArrayOf(0, 1, 1)))
        assertEquals(1, findOddInt(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)))
        assertEquals(5, findOddInt(intArrayOf(20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5)))
        assertEquals(-1, findOddInt(intArrayOf(1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5)))
        assertEquals(5, findOddInt(intArrayOf(20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5)))
        assertEquals(10, findOddInt(intArrayOf(10)))
        assertEquals(10, findOddInt(intArrayOf(1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1)))
        assertEquals(1, findOddInt(intArrayOf(5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10)))
        assertEquals(Int.MIN_VALUE, findOddInt(intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MIN_VALUE)))
        assertEquals(Int.MAX_VALUE, findOddInt(intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE, Int.MIN_VALUE)))
    }
}
