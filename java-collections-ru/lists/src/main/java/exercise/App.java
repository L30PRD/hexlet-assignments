package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {

    public static boolean scrabble(String chars, String world) {

        if (chars.equals("") || world.equals("")) {
            return false;
        }

        List<Character> worldList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();


        for (char a : world.toLowerCase().toCharArray()) {
            worldList.add(a);
        }

        for (char a : chars.toCharArray()) {
            charList.add(a);
        }

        for (char x : worldList) {
            if (charList.contains(x)) {
                charList.remove(charList.indexOf(x));
            } else {
                return false;
            }
        }

        return true;
    }
}
//END
