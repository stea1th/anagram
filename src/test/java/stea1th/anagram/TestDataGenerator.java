package stea1th.anagram;

import stea1th.anagram.keepers.LettersKeeper;

import java.util.Arrays;
import java.util.List;

public class TestDataGenerator {

    public static List<String> createLetters() {
        return Arrays.asList("d", "o", "c", "u", "m", "e", "n", "t", "i", "n", "g");
    }

    public static LettersKeeper createLettersKeeper() {
        return new LettersKeeper(createLetters());
    }

}
