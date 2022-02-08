package morsecode;

import java.util.Map;
import java.util.Set;

public class MorseCode {
    /** Dictionary of morse code letters */
    private static final Map<String, String> morseDictionary = Map.ofEntries(
            Map.entry("A", "._"),
            Map.entry("B", "_..."),
            Map.entry("C", "_._."),
            Map.entry("D", "_.."),
            Map.entry("E", "."),
            Map.entry("F", ".._."),
            Map.entry("G", "__."),
            Map.entry("H", "...."),
            Map.entry("I", ".."),
            Map.entry("J", ".___"),
            Map.entry("K", "_._"),
            Map.entry("L", "._.."),
            Map.entry("M", "__"),
            Map.entry("N", "_."),
            Map.entry("O", "___"),
            Map.entry("P", ".__."),
            Map.entry("Q", "__._"),
            Map.entry("R", "._."),
            Map.entry("S", "..."),
            Map.entry("T", "_"),
            Map.entry("U", ".._"),
            Map.entry("V", "..._"),
            Map.entry("W", ".__"),
            Map.entry("X", "_.._"),
            Map.entry("Y", "_.__"),
            Map.entry("Z", "__..")
    );

    /** Decode the morse code into a set with all possible valid words (found in resource dictionary.txt) .*/
    public static Set<String> decode(String morseCode) {
        return null;
    }
}
