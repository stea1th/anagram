package stea1th.anagram;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        String word = "documenting";
        List<String> lines = new ResourceReader().getLines();
        WordSplitter splitter = new WordSplitter();
        List<String> letters = splitter.splitStringToLetters(word);
        Map<String, List<String>> words = splitter.splitLinesToWordsMap(lines);
        LettersKeeper lettersKeeper = new LettersKeeper(letters);
        WordsKeeper wordsKeeper = new WordsKeeper(words);
        AnagramProcessor processor = new AnagramProcessor(lettersKeeper, wordsKeeper);
        processor.findAnagram();

    }

}
