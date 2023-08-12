package exercise;

// BEGIN
class App {

    public static String[][] enlargeArrayImage(String[][] image) {
        String[][] largeImage = new String[image.length * 2][image.length * 2];

        for (int i = 0; i < largeImage.length; i++) {
            for (int j = 0; j < largeImage.length; j++) {
                if (i == 0 || i == 1 || i == (largeImage.length - 1) || i == (largeImage.length - 2)
                        || j == 0 || j == 1 || j == (largeImage.length - 1) || j == (largeImage.length - 2)) {
                    largeImage[i][j] = "*";
                } else {
                    largeImage[i][j] = " ";
                }
            }
        }
        return largeImage;
    }
}
// END
