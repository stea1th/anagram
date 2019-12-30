package stea1th.anagram;

import stea1th.anagram.keepers.LettersKeeper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDataGenerator {

    public static List<String> createLetters() {
        return Arrays.asList("d", "o", "c", "u", "m", "e", "n", "t", "i", "n", "g");
    }

    public static LettersKeeper createLettersKeeper() {
        return new LettersKeeper(createLetters());
    }

    public static Map<String, List<String>> createWordMap() {
        Map<String, List<String>> wordMap = new HashMap<>();
        wordMap.put("demo", Arrays.asList("d", "e", "m", "o"));
        wordMap.put("cunting", Arrays.asList("c", "u", "n", "t", "i", "n", "g"));
        wordMap.put("eagle", Arrays.asList("e", "a", "g", "l", "e"));
        wordMap.put("unit", Arrays.asList("u", "n", "i", "t"));
        return wordMap;
    }

}
