package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path path, Car car) {
        Path absolutPath = path.toAbsolutePath().normalize();
        try {
            Files.writeString(absolutPath, Car.serialize(car), StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Car extract(Path path) {
        try {
            return Car.unserialize(Files.readString(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
// END
