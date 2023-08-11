package exercise;

import java.util.List;

// BEGIN
class App {

    public static Integer getCountOfFreeEmails(List<String> emailList) {
        long result = emailList.stream()
                .filter(mails -> mails.contains("@gmail.com")
                        || mails.contains("@yandex.ru")
                        || mails.contains("@hotmail.com"))
                .count();
        return (int) result;
    }
}
// END
