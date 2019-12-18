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

//        List<String> list = new ArrayList<>(generator.getGeneratedWords());
//        Collections.sort(list);
//        list.forEach(System.out::println);
//        System.out.println(list.size());

        WordsKeeper wordsKeeper = new WordsKeeper(words);
        AnagramProcessor processor = new AnagramProcessor(lettersKeeper, wordsKeeper);
        processor.findDoubleWordAnagram(3, 7);
    }
}
