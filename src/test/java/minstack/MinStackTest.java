package minstack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinStackTest {

    private MinStack<Integer> createStack() {
        return null; // TODO: create instance of MinStack implementation
    }

    @Test
    public void testSimplePushPeekPop() {
        var stack = createStack();

        assertTrue(stack.isEmpty());
        assertNull(stack.peek());
        assertNull(stack.pop());

        stack.push(5);
        assertFalse(stack.isEmpty());
        assertEquals(5, stack.peek());
        assertFalse(stack.isEmpty());
        assertEquals(5, stack.pop());

        assertTrue(stack.isEmpty());
        assertNull(stack.peek());
        assertNull(stack.pop());
    }

    /**
     * Test with 5, 7, 4, 1, 9
     */
    @Test
    public void testMinStackTracksMinValue() {
        var stack = createStack();

        stack.push(5);
        assertEquals(5, stack.min());
        assertEquals(5, stack.peek());

        stack.push(7);
        assertEquals(5, stack.min());
        assertEquals(7, stack.peek());

        stack.push(4);
        assertEquals(4, stack.min());
        assertEquals(4, stack.peek());

        stack.push(1);
        assertEquals(1, stack.min());
        assertEquals(1, stack.peek());

        stack.push(9);
        assertEquals(1, stack.min());
        assertEquals(9, stack.peek());

        assertEquals(9, stack.pop());
        assertEquals(1, stack.min());

        assertEquals(1, stack.pop());
        assertEquals(4, stack.min());

        assertEquals(4, stack.pop());
        assertEquals(5, stack.min());

        assertEquals(7, stack.pop());
        assertEquals(5, stack.min());

        assertEquals(5, stack.pop());
        assertTrue(stack.isEmpty());
        assertNull(stack.min());
    }

    /**
     * Test with 5, 6, 3, 3, 8, 8, 1, 1, 5
     */
    @Test
    public void testMinStackTracksMinWithMultipleEqualItems() {
        var stack = createStack();

        stack.push(5);
        assertEquals(5, stack.min());
        stack.push(7);
        assertEquals(5, stack.min());
        stack.push(3);
        assertEquals(3, stack.min());
        stack.push(3);
        assertEquals(3, stack.min());
        stack.push(8);
        assertEquals(3, stack.min());
        stack.push(8);
        assertEquals(3, stack.min());
        stack.push(1);
        assertEquals(1, stack.min());
        stack.push(1);
        assertEquals(1, stack.min());
        stack.push(5);
        assertEquals(1, stack.min());

        // Popping elements
        assertEquals(5, stack.pop());
        assertEquals(1, stack.min());
        assertEquals(1, stack.pop());
        assertEquals(1, stack.min());
        assertEquals(1, stack.pop());
        assertEquals(3, stack.min());
        assertEquals(8, stack.pop());
        assertEquals(3, stack.min());
        assertEquals(8, stack.pop());
        assertEquals(3, stack.min());
        assertEquals(3, stack.pop());
        assertEquals(3, stack.min());
        assertEquals(3, stack.pop());
        assertEquals(5, stack.min());
        assertEquals(7, stack.pop());
        assertEquals(5, stack.min());
        assertEquals(5, stack.pop());
        assertTrue(stack.isEmpty());
        assertNull(stack.min());
    }
}
