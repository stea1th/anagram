package stea1th.anagram.anagrams;

import stea1th.anagram.keepers.LettersKeeper;

import java.util.List;

class AnagramHelper {

    int checkEnd(int end, LettersKeeper letKeeper) {
        return Math.min(end, letKeeper.getLettersSize());
    }

    int checkStart(int start) {
        return Math.max(start, 3);
    }

    List<String> removeExistingLetters(List<String> allLetters, List<String> existingLetters) {
        allLetters.removeAll(existingLetters);
        return allLetters;
    }
}
