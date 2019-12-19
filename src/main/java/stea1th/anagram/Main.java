package stea1th.anagram;

import com.google.common.base.Stopwatch;
import stea1th.anagram.anagrams.AnagramFinder;
import stea1th.anagram.anagrams.AnagramFinderFactory;
import stea1th.anagram.helpers.StringSplitter;
import stea1th.anagram.keepers.LettersKeeper;
import stea1th.anagram.keepers.WordsKeeper;
import stea1th.anagram.readers.ResourceReader;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Stopwatch stopwatch = Stopwatch.createStarted();
        StringSplitter splitter = new StringSplitter();

        String word = "documenting";
//        String word = "documentingaaeer";
//        String word = "mammalinvite";
        List<String> letters = splitter.splitStringToLetters(word);
        LettersKeeper lettersKeeper = new LettersKeeper(letters);

        List<String> lines = new ResourceReader().getLines();
        Map<String, List<String>> words = splitter.splitLinesToWordsMap(lines);
        WordsKeeper wordsKeeper = new WordsKeeper(words);

        AnagramFinderFactory factory = new AnagramFinderFactory(lettersKeeper, wordsKeeper);
        AnagramFinder finder = factory.createAnagramFinder(2);
        List<String> result = finder.find(3, 7, false);

        result.forEach(System.out::println);
        stopwatch.stop();
        System.out.println(stopwatch.toString());
    }
}
