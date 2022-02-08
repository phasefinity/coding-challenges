package oddint;

import org.junit.jupiter.api.Test;

import static oddint.FindOddInt.findOddInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindOddIntTest {

    @Test
    public void easyTest() {
        // Occurrences:
        // 4 -> 2x (even)
        // 5 -> 3x (odd)
        assertEquals(5, findOddInt(new int[]{4, 4, 5, 5, 5}));
    }

    @Test
    public void testFindOddInt() {
        assertEquals(7, findOddInt(new int[]{-2, 7, -9, 7, 77, -77, 4, -77, 77, 5, 7, -2, -9, 5, 4}));
        assertEquals(1, findOddInt(new int[]{1}));
        assertEquals(0, findOddInt(new int[]{0, 1, 1}));
        assertEquals(1, findOddInt(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals(5, findOddInt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        assertEquals(-1, findOddInt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        assertEquals(5, findOddInt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        assertEquals(10, findOddInt(new int[]{10}));
        assertEquals(10, findOddInt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        assertEquals(1, findOddInt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
        assertEquals(Integer.MIN_VALUE, findOddInt(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE}));
        assertEquals(Integer.MAX_VALUE, findOddInt(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE}));
    }
}
