package stea1th.anagram.generators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stea1th.anagram.TestDataGenerator;
import stea1th.anagram.keepers.LettersKeeper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordGeneratorTest {

    private static LettersKeeper lettersKeeper;
    private WordGenerator wordGenerator;

    @BeforeAll
    static void initClass() {
        lettersKeeper = TestDataGenerator.createLettersKeeper();
    }

    @BeforeEach
    void initTest() {
        wordGenerator = new WordGenerator(lettersKeeper);
    }

    @Test
    void getSortedGeneratedWords_Random3SignWords_AlphabeticalSortedWords() {

        String expectedStart = "cde";
        String expectedFinish = "uto";

        List<String> current = wordGenerator.getSortedGeneratedWords(3);

        assertEquals(expectedStart, current.get(0));
        assertEquals(expectedFinish, current.get(current.size() - 1));
    }

    @Test
    void getSortedGeneratedWords_DoubleN_NoWordsWithTripleN() {

        String expected = "nne";
        String unexpected = "nnn";

        List<String> current = wordGenerator.getSortedGeneratedWords(3);

        assertTrue(current.contains(expected));
        assertFalse(current.contains(unexpected));
    }

}
