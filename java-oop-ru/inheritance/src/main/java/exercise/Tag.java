package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
class Tag {
    String value;
    Map<String, String> dictionary;

    public Tag(String value, Map<String, String> dictionary) {
        this.value = value;
        this.dictionary = dictionary;
    }

    public String getValue() {
        return value;
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    @Override
    public String toString() {
        return getDictionary().keySet()
                .stream()
                .map(key -> " " + key + "=" + "\"" + getDictionary().get(key) + "\"")
                .collect(Collectors.joining());
    }
}
// END
