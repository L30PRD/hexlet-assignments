package exercise;

import java.lang.reflect.Field;
import java.util.*;

// BEGIN
class Validator {

    public static List<String> validate(Address address) {
        List<String> list = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && Objects.equals(field.get(address), null)) {
                    list.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    public static Map<String, String> advancedValidate(Address address) {
        String less = "length less than 4";
        String notNull = "can not be null";
        Map<String, String> result = new HashMap<>();

        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(address);
                MinLength minLength = field.getAnnotation(MinLength.class);
                if (field.isAnnotationPresent(NotNull.class) && Objects.equals(value, null)) {
                    result.put(field.getName(), notNull);
                } else if (field.isAnnotationPresent(MinLength.class)  && value.toString().length() < minLength.minLength()) {
                    result.put(field.getName(), less);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

}
// END
