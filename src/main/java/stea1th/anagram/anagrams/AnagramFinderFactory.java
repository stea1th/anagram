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
        AnagramFinder finder;
        switch(words) {
            case 2:
            default:
                finder = new DoubleAnagramFinder(lettersKeeper, wordsKeeper);

        }
        return finder;
    }

}
