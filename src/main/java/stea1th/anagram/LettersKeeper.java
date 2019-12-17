package stea1th.anagram;

import java.util.ArrayList;
import java.util.List;

public class LettersKeeper {

    private List<String> letters;

    public LettersKeeper(List<String> letters) {
        this.letters = letters;
    }

    public List<String> getClonedLetterList() {
        return new ArrayList<>(letters);
    }
}
