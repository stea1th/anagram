package stea1th.anagram.anagrams;

import stea1th.anagram.keepers.LettersKeeper;
import stea1th.anagram.keepers.WordsKeeper;

import java.util.List;

public abstract class AnagramFinderBase implements AnagramFinder {

    LettersKeeper lettersKeeper;

    WordsKeeper wordsKeeper;

    AnagramHelper anagramHelper;


    public AnagramFinderBase(LettersKeeper lettersKeeper, WordsKeeper wordsKeeper) {
        this.lettersKeeper = lettersKeeper;
        this.wordsKeeper = wordsKeeper;
        this.anagramHelper = new AnagramHelper();
    }

    public abstract List<String> find(int start, int end);
}
