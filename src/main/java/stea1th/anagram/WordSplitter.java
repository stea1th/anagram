package stea1th.anagram;

import java.util.Arrays;
import java.util.List;

public class WordSplitter {

    public List<String> splitStringToLetters(String word) {
        String[] array = word.split("");
        return Arrays.asList(array);
    }
}
