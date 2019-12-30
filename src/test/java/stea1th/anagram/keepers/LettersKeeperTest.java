package stea1th.anagram.keepers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stea1th.anagram.TestDataGenerator;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LettersKeeperTest {

    private LettersKeeper lettersKeeper;

    @BeforeEach
    void initTest() {
        lettersKeeper = new LettersKeeper(TestDataGenerator.createLetters());
    }

    @Test
    void getClonedLetterList_LetterList_CheckNotSameButEqual() {
        List<String> expected = TestDataGenerator.createLetters();
        lettersKeeper = new LettersKeeper(expected);

        List<String> current = lettersKeeper.getClonedLetterList();

        assertNotSame(expected, current);
        assertEquals(expected, current);
    }

    @Test
    void getRepeatedLetters_DocumentingAsLetterList_TwoNOneC() {
        String expectedDoubleTime = "n";
        String expectedOneTime = "c";

        Map<String, Integer> current = lettersKeeper.getRepeatedLetters();

        assertEquals( 2, current.get(expectedDoubleTime));
        assertEquals(1, current.get(expectedOneTime));
    }

    @Test
    void countLettersInWord_PepperoniWord_3Times() {
        String word = "pepperoni";
        String letter = "p";
        int expected = 3;

        int current = lettersKeeper.countLettersInWord(word, letter);

        assertEquals(expected, current);
    }

    @Test
    void getLettersSize_DocumentingWord_11Letters() {

        int expected = 11;

        int current = lettersKeeper.getLettersSize();

        assertEquals(expected, current);
    }
}
