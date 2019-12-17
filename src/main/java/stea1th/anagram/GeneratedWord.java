package stea1th.anagram;

import java.util.HashMap;
import java.util.Map;

public class GeneratedWord {

    private Map<Integer, String> map = new HashMap<>();

    private int position;

    public GeneratedWord(int position) {
        this.position = position;
        map.put(position, "");
    }

    public void putValue(int position, String value) {
        map.put(position, value);
    }

    public String getValue(int position) {
        return map.get(position);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
