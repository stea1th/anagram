package stea1th.anagram.anagrams;

import stea1th.anagram.generators.WordGenerator;
import stea1th.anagram.keepers.LettersKeeper;
import stea1th.anagram.keepers.WordsKeeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AnagramFinderBase implements AnagramFinder {

    LettersKeeper lettersKeeper;

    WordsKeeper wordsKeeper;

    AnagramHelper anagramHelper;


    AnagramFinderBase(LettersKeeper lettersKeeper, WordsKeeper wordsKeeper) {
        this.lettersKeeper = lettersKeeper;
        this.wordsKeeper = wordsKeeper;
        this.anagramHelper = new AnagramHelper();
    }

    public abstract List<String> find(int start, int end, boolean isSameWordLength);

    List<String> findAnagrams(int start, int end, boolean isSameWordLength, LettersKeeper letKeeper) {
        start = anagramHelper.checkStart(start);
        end = anagramHelper.checkEnd(end, letKeeper);
        Map<String, List<String>> wordsMap = wordsKeeper.getClonedWordsMap();
        Set<String> words = wordsMap.keySet();
        List<String> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            WordGenerator generator = new WordGenerator(letKeeper);
            generator.generate(i);
            List<String> generated = generator.getSortedGeneratedWords();
            generated.stream()
                    .filter(words::contains)
                    .forEach(word -> {
                        List<String> list = anagramHelper.removeExistingLetters(letKeeper.getClonedLetterList(), wordsMap.get(word));
                        if (isSameWordLength) {
                            if (list.isEmpty())
                                result.add(word);
                        } else
                            result.add(word);
                    });
        }
        return result;
    }

    List<String> findAnagrams(int start, int end, boolean isSameWordLength) {
        return findAnagrams(start, end, isSameWordLength, lettersKeeper);
    }
}
