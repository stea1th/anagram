package stea1th.anagram.keepers;

import org.junit.jupiter.api.Test;
import stea1th.anagram.TestDataGenerator;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordsKeeperTest {

    @Test
    void getClonedWordsMap_WordMap_CheckNotSameButEqual() {
        Map<String, List<String>> expected = TestDataGenerator.createWordMap();
        WordsKeeper wordsKeeper = new WordsKeeper(expected);

        Map<String, List<String>> current = wordsKeeper.getClonedWordsMap();

        assertNotSame(expected, current);
        assertEquals(expected, current);
    }
}
