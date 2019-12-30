package stea1th.anagram.anagrams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stea1th.anagram.TestDataGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DoubleAnagramFinderTest {

    private DoubleAnagramFinder doubleAnagramFinder;

    @BeforeEach
    void initTest() {
        doubleAnagramFinder = new DoubleAnagramFinder(TestDataGenerator.createLettersKeeper(), TestDataGenerator.createWordsKeeper());
    }

    @Test
    void find_From3To7SignsAndNotAllLetters_2Results() {
        String expectedOne = "demo unit";
        String expectedTwo = "cunting demo";

        List<String> current = doubleAnagramFinder.find(3, 7, false);

        assertTrue(current.contains(expectedOne));
        assertTrue(current.contains(expectedTwo));
        assertEquals(2, current.size());
    }

    @Test
    void find_From3To7SignsAndAllLetters_1Results() {
        String expected = "cunting demo";

        List<String> current = doubleAnagramFinder.find(3, 7, true);

        assertTrue(current.contains(expected));
        assertEquals(1, current.size());
    }
}
