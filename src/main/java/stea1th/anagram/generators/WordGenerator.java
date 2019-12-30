package stea1th.anagram.generators;

import stea1th.anagram.keepers.LettersKeeper;
import stea1th.anagram.transports.GeneratedWord;

import java.util.*;

public class WordGenerator {

    private LettersKeeper lettersKeeper;

    private Set<String> generatedWords = new HashSet<>();

    public WordGenerator(LettersKeeper lettersKeeper) {
        this.lettersKeeper = lettersKeeper;
    }

    public List<String> getSortedGeneratedWords(int size) {
        generateWords(size);
        return sortWords();
    }

    private List<String> sortWords() {
        List<String> list = new ArrayList<>(generatedWords);
        Collections.sort(list);
        return list;
    }

    private void generateWords(int size) {
        List<String> letters = lettersKeeper.getClonedLetterList();

        for (String letter : letters) {
            GeneratedWord generatedWord = new GeneratedWord(size);
            generatedWord.putValue(size, letter);
            generateWords(generatedWord);
        }
    }

    private GeneratedWord generateWords(GeneratedWord generatedWord) {
        int size = generatedWord.getPosition();
        if (size > 1) {
            List<String> letters = lettersKeeper.getClonedLetterList();
            for (String letter : letters) {
                size = generatedWord.getPosition();
                String word = generatedWord.getValue(size);
                int repeatedLetter = lettersKeeper.getRepeatedLetters().get(letter);
                if (!word.contains(letter) || repeatedLetter > lettersKeeper.countLettersInWord(word, letter)) {
                    word += letter;
                    if (!generatedWords.contains(word)) {
                        generatedWord.setPosition(--size);
                        generatedWord.putValue(size, word);
                        generatedWord = generateWords(generatedWord);
                    }
                }
            }
        } else if (size == 1) {
            generatedWords.add(generatedWord.getValue(size));
        }
        generatedWord.setPosition(generatedWord.getPosition() + 1);
        return generatedWord;
    }
}
