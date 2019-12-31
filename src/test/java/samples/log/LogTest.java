package samples.log;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;

public class LogTest {

    private static final Logger log = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void logMessage() {
        log.error("Date today: {} and Time today: {}", LocalDate.now(), LocalTime.now());
    }
}
