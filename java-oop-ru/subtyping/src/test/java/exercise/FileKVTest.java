package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void workingTest() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "1"));
        assertThat(storage.get("key2", "default")).isEqualTo("default");
        assertThat(storage.get("key", "default")).isEqualTo("1");

        storage.set("key2", "value2");
        storage.set("key", "value");

        assertThat(storage.get("key2", "default")).isEqualTo("value2");
        assertThat(storage.get("key", "default")).isEqualTo("value");

        storage.unset("key");
        assertThat(storage.get("key", "difference")).isEqualTo("difference");
        assertThat(storage.toMap()).isEqualTo(Map.of("key2", "value2"));
    }
    // END
}
