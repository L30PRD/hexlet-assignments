package exercise;

// BEGIN

// END

public final class App {

    public static Javalin getApp() {

        // BEGIN
        System.out.println("Test");
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
