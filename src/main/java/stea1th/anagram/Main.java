package stea1th.anagram;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String word = "documenting";
        List<String> lines = new ResourceReader().getLines();
        StringSplitter splitter = new StringSplitter();
        List<String> letters = splitter.splitStringToLetters(word);
        Map<String, List<String>> words = splitter.splitLinesToWordsMap(lines);
        LettersKeeper lettersKeeper = new LettersKeeper(letters);

        WordsKeeper wordsKeeper = new WordsKeeper(words);
        AnagramProcessor processor = new AnagramProcessor(lettersKeeper, wordsKeeper);
        processor.findAnagrams(3, 7).forEach(System.out::println);
    }
}
