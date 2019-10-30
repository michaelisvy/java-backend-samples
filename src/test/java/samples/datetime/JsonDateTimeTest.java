package samples.datetime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.StringWriter;
import java.time.ZonedDateTime;

public class JsonDateTimeTest {
    @Test
    public void shouldSerialiseDate() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        // can also be done with objectMapper.findAndRegisterModules();

        Book book = new Book();
        book.setPublishingTime(ZonedDateTime.now());
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, book);
        Assertions.assertThat(stringWriter).isNotNull();
        System.out.println("Employee JSON is\n" + stringWriter);

    }
}
