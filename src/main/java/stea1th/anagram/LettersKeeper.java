package stea1th.anagram;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LettersKeeper {

    private List<String> letters;

    private Map<String, Integer> repeatedLetters;

    public LettersKeeper(List<String> letters) {
        this.letters = letters;
        this.repeatedLetters = findAllRepeatedLetters(letters);

    }

    public List<String> getClonedLetterList() {
        return new ArrayList<>(letters);
    }

    public Map<String, Integer> getRepeatedLetters() {
        return repeatedLetters;
    }

    public int countLettersInWord(String word, String letter) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (letter.equals(word.substring(i, i + 1))) {
                count++;
            }
        }
        return count;
    }

    public int getLettersSize() {
        return letters.size();
    }

    private Map<String, Integer> findAllRepeatedLetters(List<String> letters) {
        return letters.parallelStream().
                collect(Collectors.toConcurrentMap(
                        w -> w, w -> 1, Integer::sum));
    }


}
