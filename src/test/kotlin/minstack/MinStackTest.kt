package minstack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MinStackTest {
    private fun createStack(): MinStack<Int> {
        return TODO("create instance of MinStack implementation")
    }

    @Test
    fun `test simple push peek pop`() {
        val stack = createStack()
        assertTrue(stack.isEmpty)
        assertNull(stack.peek())
        assertNull(stack.pop())
        stack.push(5)
        assertFalse(stack.isEmpty)
        assertEquals(5, stack.peek())
        assertFalse(stack.isEmpty)
        assertEquals(5, stack.pop())
        assertTrue(stack.isEmpty)
        assertNull(stack.peek())
        assertNull(stack.pop())
    }

    /**
     * Test with 5, 7, 4, 1, 9
     */
    @Test
    fun `test min stack tracks min value`() {
        val stack = createStack()
        stack.push(5)
        assertEquals(5, stack.min())
        assertEquals(5, stack.peek())
        stack.push(7)
        assertEquals(5, stack.min())
        assertEquals(7, stack.peek())
        stack.push(4)
        assertEquals(4, stack.min())
        assertEquals(4, stack.peek())
        stack.push(1)
        assertEquals(1, stack.min())
        assertEquals(1, stack.peek())
        stack.push(9)
        assertEquals(1, stack.min())
        assertEquals(9, stack.peek())
        assertEquals(9, stack.pop())
        assertEquals(1, stack.min())
        assertEquals(1, stack.pop())
        assertEquals(4, stack.min())
        assertEquals(4, stack.pop())
        assertEquals(5, stack.min())
        assertEquals(7, stack.pop())
        assertEquals(5, stack.min())
        assertEquals(5, stack.pop())
        assertTrue(stack.isEmpty)
        assertNull(stack.min())
    }

    /**
     * Test with 5, 6, 3, 3, 8, 8, 1, 1, 5
     */
    @Test
    fun `test min stack tracks min with multiple equal items`() {
        val stack = createStack()
        stack.push(5)
        assertEquals(5, stack.min())
        stack.push(7)
        assertEquals(5, stack.min())
        stack.push(3)
        assertEquals(3, stack.min())
        stack.push(3)
        assertEquals(3, stack.min())
        stack.push(8)
        assertEquals(3, stack.min())
        stack.push(8)
        assertEquals(3, stack.min())
        stack.push(1)
        assertEquals(1, stack.min())
        stack.push(1)
        assertEquals(1, stack.min())
        stack.push(5)
        assertEquals(1, stack.min())

        // Popping elements
        assertEquals(5, stack.pop())
        assertEquals(1, stack.min())
        assertEquals(1, stack.pop())
        assertEquals(1, stack.min())
        assertEquals(1, stack.pop())
        assertEquals(3, stack.min())
        assertEquals(8, stack.pop())
        assertEquals(3, stack.min())
        assertEquals(8, stack.pop())
        assertEquals(3, stack.min())
        assertEquals(3, stack.pop())
        assertEquals(3, stack.min())
        assertEquals(3, stack.pop())
        assertEquals(5, stack.min())
        assertEquals(7, stack.pop())
        assertEquals(5, stack.min())
        assertEquals(5, stack.pop())
        assertTrue(stack.isEmpty)
        assertNull(stack.min())
    }
}
