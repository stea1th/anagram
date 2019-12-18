package stea1th.anagram;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordGenerator {

    private LettersKeeper keeper;

    private Set<String> generatedWords = new HashSet<>();

    public WordGenerator(LettersKeeper keeper) {
        this.keeper = keeper;
    }

    public void generateIt(int size) {
        List<String> letters = keeper.getClonedLetterList();

        for (String letter : letters) {
            GeneratedWord generatedWord = new GeneratedWord(size);
            generatedWord.putValue(size, letter);
            generate(generatedWord);
        }
    }

    public GeneratedWord generate(GeneratedWord generatedWord) {
        int size = generatedWord.getPosition();
        if (size > 1) {
            List<String> letters = keeper.getClonedLetterList();
            for (int i = 0; i < letters.size(); i++) {
                String letter = letters.get(i);
                size = generatedWord.getPosition();
                String word = generatedWord.getValue(size);
                if (!word.contains(letter)) {
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

    public Set<String> getGeneratedWords() {
        return generatedWords;
    }
}
