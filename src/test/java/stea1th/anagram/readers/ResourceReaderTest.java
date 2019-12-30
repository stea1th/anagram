package stea1th.anagram.readers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResourceReaderTest {

    private ResourceReader resourceReader = new ResourceReader();

    @Test
    void getLines_FromResourcesFile_Lines() {
        int expected = 273;

        List<String> current = resourceReader.getLines();

        assertEquals(expected, current.size());
    }
}
