package stea1th.anagram.keepers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsKeeper {

    private Map<String, List<String>> words;

    public WordsKeeper(Map<String, List<String>> words) {
        this.words = words;
    }

    public Map<String, List<String>> getClonedWordsMap() {
        return new HashMap<>(words);
    }
}
