package stea1th.anagram.anagrams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stea1th.anagram.TestDataGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SingleAnagramFinderTest {

    private SingleAnagramFinder singleAnagramFinder;

    @BeforeEach
    void initTest() {
        singleAnagramFinder = new SingleAnagramFinder(TestDataGenerator.createLettersKeeper(), TestDataGenerator.createWordsKeeper());
    }

    @Test
    void find_From3To4SignsAndNotAllLetters_2Results() {

        String expectedOne = "demo";
        String expectedTwo = "unit";

        List<String> current = singleAnagramFinder.find(3, 4, false);

        assertTrue(current.contains(expectedOne));
        assertTrue(current.contains(expectedTwo));
        assertEquals(2, current.size());
    }
}
