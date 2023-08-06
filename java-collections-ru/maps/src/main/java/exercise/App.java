package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {

    public static Map<String, Integer> getWordCount(String line) {

        Map<String, Integer> map = new HashMap<>();

        for (String text : line.split(" ")) {
            int count = 1;
            if (line.equals("")) {
                return map;
            } else if (map.containsKey(text)) {
                map.put(text, map.get(text) + count);
            } else {
                map.put(text, count);
            }
        }

        return map;

    }


    public static String toString(Map<String, Integer> map) {
        StringBuilder stb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stb.append("  ")
                    .append(entry.getKey()).append(":").append(" ")
                    .append(entry.getValue()).append("\n");
        }
        if (map.isEmpty()) {
            return "{}";
        }
        return "{\n" + stb + "}";
    }
}
//END
