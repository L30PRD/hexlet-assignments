package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    String path;

    public FileKV(String path, Map<String, String> map) {
        Map<String, String> firstMap = new HashMap<>(map);
        String result = Utils.serialize(firstMap);
        Utils.writeFile(path, result);
        this.path = path;
    }

    @Override
    public void set(String key, String value) {
        String fileData = Utils.readFile(this.path);
        Map<String, String> unserializedMap = new HashMap<>(Utils.unserialize(fileData));
        unserializedMap.put(key, value);
        String result = Utils.serialize(unserializedMap);
        Utils.writeFile(path, result);
    }

    @Override
    public void unset(String key) {
        String fileData = Utils.readFile(this.path);
        Map<String, String> unserializedMap = new HashMap<>(Utils.unserialize(fileData));
        unserializedMap.remove(key);
        String result = Utils.serialize(unserializedMap);
        Utils.writeFile(path, result);
    }

    @Override
    public String get(String key, String defaultValue) {
        String fileData = Utils.readFile(this.path);
        Map<String, String> unserializedMap = new HashMap<>(Utils.unserialize(fileData));
        return unserializedMap.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(Utils.unserialize(Utils.readFile(path)));
    }
}
// END
