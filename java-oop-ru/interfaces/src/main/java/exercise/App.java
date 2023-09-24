package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {

    public static List<String> buildApartmentsList(List<Home> list, Integer n ) {

        List<String> result = list
                .stream()
                .sorted(Home::compareTo)
                .map(Home::toString)
                .collect(Collectors.toList());
        if (n > result.size()) {
            n = result.size();
        }

        return result.subList(0, n);
    }
}
// END
