package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    @Test
    void testAdvancedValidate() {
        String length = "length less than 4";
        String notNull = "can not be null";

        Address address1 = new Address("Russia", "Vladivostok", "Lenina", "54", null);
        Map<String, String> result1 = Validator.advancedValidate(address1);
        Map<String, String> expected1 = Map.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        Map<String, String> result2 = Validator.advancedValidate(address2);
        Map<String, String> expected2 = Map.of("country", notNull );
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("Russia", "Uf", "Lenina", "54", null);
        Map<String, String> result3 = Validator.advancedValidate(address3);
        Map<String, String> expected3 = Map.of("city", length);
        assertThat(result3).isEqualTo(expected3);
    }
}
