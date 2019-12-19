package stea1th.anagram.anagrams;

import stea1th.anagram.keepers.LettersKeeper;
import stea1th.anagram.generators.WordGenerator;
import stea1th.anagram.keepers.WordsKeeper;

import java.util.*;

public class DoubleAnagramFinder extends AnagramFinderBase {

    DoubleAnagramFinder(LettersKeeper lettersKeeper, WordsKeeper wordsKeeper) {
        super(lettersKeeper, wordsKeeper);
    }

    @Override
    public List<String> find(int start, int end, boolean isSameWordLength) {
        int newStart = anagramHelper.checkStart(start);
        int newEnd = anagramHelper.checkEnd(end, lettersKeeper);
        Map<String, List<String>> wordsMap = wordsKeeper.getClonedWordsMap();
        Set<String> words = wordsMap.keySet();
        Set<String> result = new HashSet<>();
        for (int i = newStart; i <= newEnd; i++) {
            WordGenerator generator = new WordGenerator(lettersKeeper);
            generator.generate(i);
            List<String> generated = generator.getSortedGeneratedWords();
            generated.stream()
                    .filter(words::contains)
                    .forEach(word -> {
                        List<String> list = anagramHelper.removeExistingLetters(lettersKeeper.getClonedLetterList(), wordsMap.get(word));
                        LettersKeeper newLettersKeeper = new LettersKeeper(list);
                        List<String> secondWords = getSecondWordsForAnagram(newStart, newEnd, isSameWordLength, newLettersKeeper);
                        if (!secondWords.isEmpty()) {
                            secondWords.forEach(w -> result.add(anagramHelper.compareWords(word, w)));
                        }
                    });
        }
        return new ArrayList<>(result);
    }

    private List<String> getSecondWordsForAnagram(int start, int end, boolean isSameWordLength, LettersKeeper letKeeper) {
        return findLastAnagram(start, end, isSameWordLength, letKeeper);
    }
}
