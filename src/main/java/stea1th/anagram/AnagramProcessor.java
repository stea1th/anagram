package stea1th.anagram;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnagramProcessor {

    private LettersKeeper lettersKeeper;

    private WordsKeeper wordsKeeper;

    public AnagramProcessor(LettersKeeper lettersKeeper, WordsKeeper wordsKeeper) {
        this.lettersKeeper = lettersKeeper;
        this.wordsKeeper = wordsKeeper;
    }

    public void findAnagram() {
        Map<String, List<String>> words = wordsKeeper.getClonedWordsMap();
        for (String key : words.keySet()) {
            List<String> wordsLetters = new ArrayList<>();
            for (String letter : lettersKeeper.getClonedLetterList()) {
                if (key.contains(letter) && !isThereDuplicate(key, letter)) {
                    wordsLetters.add(letter);
                }
            }
            int size = wordsLetters.size();
            if (size > 4) {
                System.out.println(key);
            }
        }
    }

    public boolean isThereDuplicate(String word, String letter) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (letter.equals(word.substring(i, i + 1))) {
                count++;
            }
        }
        return count > 1;
    }
}
