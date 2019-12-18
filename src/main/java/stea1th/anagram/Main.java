package stea1th.anagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String word = "documenting";
        List<String> lines = new ResourceReader().getLines();
        WordSplitter splitter = new WordSplitter();
        List<String> letters = splitter.splitStringToLetters(word);
        Map<String, List<String>> words = splitter.splitLinesToWordsMap(lines);
        LettersKeeper lettersKeeper = new LettersKeeper(letters);
//        WordsKeeper wordsKeeper = new WordsKeeper(words);
//        AnagramProcessor processor = new AnagramProcessor(lettersKeeper, wordsKeeper);
//        processor.findAnagram();
        WordGenerator generator = new WordGenerator(lettersKeeper);
        generator.generateIt(4);
        List<String> list = new ArrayList<>(generator.getGeneratedWords());
        Collections.sort(list);
        list.forEach(w-> System.out.println(w));
        System.out.println(list.size());

    }

}
