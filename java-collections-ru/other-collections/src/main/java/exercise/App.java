package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

// BEGIN
class App {

    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new HashMap<>();

        if (data2.isEmpty() && !data1.isEmpty()) {
            for (Map.Entry<String, Object> entry : data1.entrySet()) {
                result.put(entry.getKey(), "deleted");
            }
        }

        if (data1.isEmpty() && !data2.isEmpty()) {
            for (Map.Entry<String, Object> entry : data2.entrySet()) {
                result.put(entry.getKey(), "added");
            }
        }

//        for (Map.Entry<String, Object> x : data1.entrySet()) {
//            for (Map.Entry<String, Object> y : data2.entrySet()) {
//                if (x.equals(y)) {
//                    result.put(x.getKey(), "unchanged");
//                }
//                if (!(x.equals(y))) {
//                    result.put(x.getKey(), "changed");
//                }
//
//                if (!(data2.containsKey(x.getKey()))) {
//                    result.put(x.getKey(), "deleted");
//                }
//                if (!(data1.containsKey(y.getKey()))) {
//                    result.put(y.getKey(), "added");
//                }
//            }
//        }

        NavigableSet<String> nav = new TreeSet<>();

        for (Map.Entry<String, Object> x : data1.entrySet()) {
            for (Map.Entry<String, Object> y : data2.entrySet()) {
                nav.add(x.getKey());
                nav.add(y.getKey());
            }
        }

        nav.forEach(x -> {
            boolean key1 = data1.containsKey(x);
            boolean key2 = data2.containsKey(x);

            if (key1 && key2) {
                if (data1.get(x).equals(data2.get(x))) {
                    result.put(x, "unchanged");
                } else {
                    result.put(x, "changed");
                }
            }

            if (key1 && !key2) {
                result.put(x, "deleted");
            }

            if (!key1 & key2) {
                result.put(x, "added");
            }
        });

        return result;
    }
}
//END
