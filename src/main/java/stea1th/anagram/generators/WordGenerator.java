package stea1th.anagram.generators;

import stea1th.anagram.keepers.LettersKeeper;
import stea1th.anagram.transport.GeneratedWord;

import java.util.*;

public class WordGenerator {

    private LettersKeeper keeper;

    private Set<String> generatedWords = new HashSet<>();

    public WordGenerator(LettersKeeper keeper) {
        this.keeper = keeper;
    }

    public List<String> getSortedGeneratedWords() {
        List<String> list = new ArrayList<>(generatedWords);
        Collections.sort(list);
        return list;
    }

    public void generate(int size) {
        List<String> letters = keeper.getClonedLetterList();

        for (String letter : letters) {
            GeneratedWord generatedWord = new GeneratedWord(size);
            generatedWord.putValue(size, letter);
            generate(generatedWord);
        }
    }

    private GeneratedWord generate(GeneratedWord generatedWord) {
        int size = generatedWord.getPosition();
        if (size > 1) {
            List<String> letters = keeper.getClonedLetterList();
            for (String letter : letters) {
                size = generatedWord.getPosition();
                String word = generatedWord.getValue(size);
                int repeatedLetter = keeper.getRepeatedLetters().get(letter);
                if (!word.contains(letter) || repeatedLetter > keeper.countLettersInWord(word, letter)) {
                    word += letter;
                    if (!generatedWords.contains(word)) {
                        generatedWord.setPosition(--size);
                        generatedWord.putValue(size, word);
                        generatedWord = generate(generatedWord);
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