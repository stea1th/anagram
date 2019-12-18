package stea1th.anagram.anagrams;

import stea1th.anagram.keepers.LettersKeeper;
import stea1th.anagram.keepers.WordsKeeper;

public class AnagramFinderFactory {

    private LettersKeeper lettersKeeper;

    private WordsKeeper wordsKeeper;


    public AnagramFinderFactory(LettersKeeper lettersKeeper, WordsKeeper wordsKeeper) {
        this.lettersKeeper = lettersKeeper;
        this.wordsKeeper = wordsKeeper;
    }

    public AnagramFinder createAnagramFinder(int words) {
        switch(words) {
            case 1:
                return new SingleAnagramFinder(lettersKeeper, wordsKeeper);
            case 2:
            default:
                return new DoubleAnagramFinder(lettersKeeper, wordsKeeper);
        }
    }
}
