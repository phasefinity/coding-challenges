package morsecode;

import org.junit.jupiter.api.Test;

import static java.util.Set.of;
import static morsecode.MorseCode.decode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseCodeTest {

    @Test
    public void testDecodeMorseCode() {
        assertEquals(of("hello"), decode("......_..._..___"));
        assertEquals(of("world"), decode("._____._.._.._.."));
    }

    @Test
    public void testDecodeMorseCodeWithMultipleCombinations() {
        assertEquals(of("lever", "river"), decode("._......_.._."));
    }
}
