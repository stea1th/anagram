package stea1th.anagram.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringSplitter {

    public List<String> splitStringToLetters(String word) {
        String[] array = word.split("");
        return Arrays.asList(array);
    }

    public Map<String, List<String>> splitLinesToWordsMap(List<String> lines) {
        List<String> words = new ArrayList<>();
        lines.stream()
                .map(line -> Arrays.asList(line.split(" ")))
                .map(w -> {
                    List<String> list = new ArrayList<>();
                    for (String x : w) {
                        if (!x.equals(""))
                            list.add(x);
                    }
                    return list;
                })
                .forEach(words::addAll);
        return words.stream().collect(Collectors.toMap(string -> string, this::splitStringToLetters));
    }
}
