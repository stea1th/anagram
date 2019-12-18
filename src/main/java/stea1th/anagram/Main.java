package stea1th.anagram;

import stea1th.anagram.anagrams.AnagramFinder;
import stea1th.anagram.anagrams.AnagramFinderFactory;
import stea1th.anagram.helper.StringSplitter;
import stea1th.anagram.keepers.LettersKeeper;
import stea1th.anagram.keepers.WordsKeeper;
import stea1th.anagram.readers.ResourceReader;

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

        AnagramFinderFactory factory = new AnagramFinderFactory(lettersKeeper, wordsKeeper);
        AnagramFinder finder = factory.createAnagramFinder(2);
        finder.find(3,7).forEach(System.out::println);
    }
}
