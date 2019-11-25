package samples.datetime.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.io.StringWriter;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class JsonDateTimeTest {

    @Autowired
    private ObjectMapper jacksonObjectMapper;

    @Test
    public void shouldSerialiseDateWithBoot() throws Exception {

        Book book = buildBook();
        StringWriter stringWriter = new StringWriter();
        this.jacksonObjectMapper.writeValue(stringWriter, book);
        assertThat(stringWriter).isNotNull();
        System.out.println("Employee JSON is\n" + stringWriter);
    }

    @Test
    public void shouldSerialiseDateNoBoot() throws Exception {

        System.out.println(jacksonObjectMapper);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        // can also be done with objectMapper.findAndRegisterModules();

        Book book = buildBook();
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, book);
        assertThat(stringWriter).isNotNull();
        System.out.println("Employee JSON is\n" + stringWriter);
    }

    private Book buildBook() {
        Book book = new Book();
        book.setPublishingTime(ZonedDateTime.now());
        book.setPublishingDate(LocalDate.now());
        return book;
    }
}
