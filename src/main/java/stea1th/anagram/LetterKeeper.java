package stea1th.anagram;

import java.util.ArrayList;
import java.util.List;

public class LetterKeeper {

    private List<String> letters;

    public LetterKeeper(List<String> letters) {
        this.letters = letters;
    }

    public List<String> getClonedLetterList() {
        return new ArrayList<>(letters);
    }
}
