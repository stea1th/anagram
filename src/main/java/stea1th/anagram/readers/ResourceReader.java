package stea1th.anagram.readers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ResourceReader {

    public List<String> getLines() {
        List<String> lines = new ArrayList<>();
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            lines = Files.readAllLines(Paths.get(new File(classLoader.getResource("words.txt").getFile()).getPath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}
