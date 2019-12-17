package stea1th.anagram;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String word = "documenting";
        WordSplitter splitter = new WordSplitter();
        List<String> letters = splitter.splitStringToLetters(word);
        LetterKeeper keeper = new LetterKeeper(letters);
        List<String> newList = keeper.getClonedLetterList();
    }
}
