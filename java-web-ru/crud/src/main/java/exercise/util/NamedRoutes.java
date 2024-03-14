package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String indexPath() {
        return "/post";
    }

    public static String showPath() {
        return "/posts/{id}";
    }
    // END
}
