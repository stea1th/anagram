package stea1th.anagram;

import javafx.util.Pair;

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
        List<Pair<String, String>> result = new ArrayList<>();
        for(String key : words.keySet()) {
            List<String> wordsLetters =  new ArrayList<>();
            int count = 0;
            for(String letter : lettersKeeper.getClonedLetterList()) {
                if(key.contains(letter)) {
                    wordsLetters.add(letter);
                    count++;
                }
            }
            int size = wordsLetters.size();
            if(size > 4 && count == size) {
                System.out.println(key);
            }
        }
    }
}
