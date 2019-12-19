package stea1th.anagram.anagrams;

import stea1th.anagram.keepers.LettersKeeper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class AnagramHelper {

    int checkEnd(int end, LettersKeeper letKeeper) {
        return Math.min(end, letKeeper.getLettersSize());
    }

    int checkStart(int start) {
        return Math.max(start, 3);
    }

    List<String> removeExistingLetters(List<String> allLetters, List<String> existingLetters) {
        existingLetters.forEach(allLetters::remove);
        return allLetters;
    }

    String compareWords(String word1, String word2) {
        List<String> list = Arrays.asList(word1, word2);
        list.sort(Comparator.naturalOrder());
        return list.get(0) + " " + list.get(1);
    }
}
