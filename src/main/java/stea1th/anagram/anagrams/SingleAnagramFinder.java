package stea1th.anagram.anagrams;

import stea1th.anagram.keepers.LettersKeeper;
import stea1th.anagram.keepers.WordsKeeper;

import java.util.List;

public class SingleAnagramFinder extends AnagramFinderBase {


    SingleAnagramFinder(LettersKeeper lettersKeeper, WordsKeeper wordsKeeper) {
        super(lettersKeeper, wordsKeeper);
    }

    @Override
    public List<String> find(int start, int end, boolean isSameWordLength) {
        return findLastAnagram(start, end, isSameWordLength);
    }
}
