package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App{
    public static void swapKeyValue(KeyValueStorage storage) {

        for (Map.Entry<String, String> set : storage.toMap().entrySet()) {
            String key = storage.get(set.getKey(), "default");
            storage.unset(set.getKey());
            storage.set(key, set.getKey());
        }
    }
}
// END
