package stea1th.anagram.helpers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringSplitterTest {

    private StringSplitter stringSplitter = new StringSplitter();

    @Test
    void splitStringToLetters_DemoWord_4SizedList() {
        String word = "demo";

        List<String> current = stringSplitter.splitStringToLetters(word);

        assertEquals(4, current.size());
    }

    @Test
    void splitLinesToWordsMap_LineWith3Words_3SizedMap() {
        String line = "mama papa dada";

        Map<String, List<String>> current = stringSplitter.splitLinesToWordsMap(Collections.singletonList(line));

        assertEquals(3, current.size());
    }
}
