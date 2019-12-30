package stea1th.anagram.anagrams;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import stea1th.anagram.TestDataGenerator;

import static org.junit.jupiter.api.Assertions.*;

class AnagramFinderFactoryTest {

    private static AnagramFinderFactory anagramFinderFactory;

    @BeforeAll
    static void initClass() {
        anagramFinderFactory = new AnagramFinderFactory(TestDataGenerator.createLettersKeeper(), TestDataGenerator.createWordsKeeper());
    }

    @Test
    void createAnagramFinder_One_SingleAnagram() {
        AnagramFinder anagramFinder = anagramFinderFactory.createAnagramFinder(1);

        assertTrue(anagramFinder instanceof SingleAnagramFinder);
    }

    @Test
    void createAnagramFinder_Two_DoubleAnagram() {
        AnagramFinder anagramFinder = anagramFinderFactory.createAnagramFinder(2);

        assertTrue(anagramFinder instanceof DoubleAnagramFinder);
    }

    @Test
    void createAnagramFinder_MoreThanTwo_DoubleAnagram() {
        AnagramFinder anagramFinder = anagramFinderFactory.createAnagramFinder(5);

        assertTrue(anagramFinder instanceof DoubleAnagramFinder);
    }
}
