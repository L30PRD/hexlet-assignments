package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {

    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> bookMap : books) {
            if(bookMap.entrySet().containsAll(where.entrySet())){
                result.add(bookMap);
            }
        }

        return result;
    }
}
//END
