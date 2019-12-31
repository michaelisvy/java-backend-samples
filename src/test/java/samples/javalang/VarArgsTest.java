package samples.javalang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class VarArgsTest {

    private String greet(String greeter, String... names) {
        String message = greeter;
        if (names.length > 0)
            message += " " + String.join(", ", names);

        return message;
    }

    @Test
    public void shouldJustGreet() {
        String message = greet("hello");
        assertThat(message).isEqualTo("hello");
    }

    @Test
    public void shouldGreet2People() {
        String message = greet("hello", "John", "Sam");
        assertThat(message).isEqualTo("hello John, Sam");
    }
}
