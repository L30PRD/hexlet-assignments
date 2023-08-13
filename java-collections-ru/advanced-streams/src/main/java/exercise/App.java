package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {

    public static String getForwardedVariables(String line) {
        return Arrays.stream(line.split("\n"))
                        .filter(x -> x.startsWith("environment="))
                        .map(x -> x.replaceAll("\"", "").replaceAll(" ", ""))
                        .map(x -> x.replaceFirst("environment=", ""))
                        .map(x -> x.split(","))
                        .flatMap(Arrays::stream)
                        .filter(x -> x.startsWith("X_FORWARDED_"))
                        .map(x -> x.replaceAll("X_FORWARDED_", ""))
                        .collect(Collectors.joining(","));
    }
}
//END
