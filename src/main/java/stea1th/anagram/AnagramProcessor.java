package stea1th.anagram;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnagramProcessor {

    private LettersKeeper lettersKeeper;

    private WordsKeeper wordsKeeper;


    public AnagramProcessor(LettersKeeper lettersKeeper, WordsKeeper wordsKeeper) {
        this.lettersKeeper = lettersKeeper;
        this.wordsKeeper = wordsKeeper;
    }


    public List<String> findAnagrams(int start, int end) {
        int newStart = checkStart(start);
        int newEnd = checkEnd(end, lettersKeeper);
        Map<String, List<String>> wordsMap = wordsKeeper.getClonedWordsMap();
        Set<String> words = wordsMap.keySet();
        List<String> result = new ArrayList<>();
        for (int i = newStart; i <= newEnd; i++) {
            WordGenerator generator = new WordGenerator(lettersKeeper);
            generator.generate(i);
            List<String> generated = generator.getSortedGeneratedWords();
            generated.stream()
                    .filter(words::contains)
                    .forEach(word -> {
                        List<String> list = removeExistingLetters(lettersKeeper.getClonedLetterList(), wordsMap.get(word));
                        StringBuilder stringBuilder = new StringBuilder(word);
                        LettersKeeper newLettersKeeper = new LettersKeeper(list);
                        List<String> secondWords = getSecondWordsForAnagram(newStart, newEnd, newLettersKeeper);
                        if (!secondWords.isEmpty()) {
                            secondWords.forEach(w -> {
                                stringBuilder.append(" ").append(w);
                                result.add(stringBuilder.toString());
                            });
                        }
                    });
        }
        return result;
    }

    private List<String> getSecondWordsForAnagram(int start, int end, LettersKeeper letKeeper) {
        end = checkEnd(end, letKeeper);
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
                        List<String> list = removeExistingLetters(letKeeper.getClonedLetterList(), wordsMap.get(word));
                        if (list.isEmpty()) {
                            result.add(word);
                        }
                    });
        }
        return result;
    }

    private int checkEnd(int end, LettersKeeper letKeeper) {
        return Math.min(end, letKeeper.getLettersSize());
    }

    private int checkStart(int start) {
        return Math.max(start, 3);
    }

    private List<String> removeExistingLetters(List<String> allLetters, List<String> existingLetters) {
        allLetters.removeAll(existingLetters);
        return allLetters;
    }

}
