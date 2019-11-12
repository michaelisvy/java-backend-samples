package samples.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.*;

public class LocalTimeTest {

    @Test
    public void shouldBeGreater() {
        LocalTime now = getCurrentTime();
        LocalTime earlier = getTimeOneMinuteAgo();

        assertThat(earlier).isBefore(now);

    }

    private LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    private LocalTime getTimeOneMinuteAgo() {
        return getCurrentTime().minusMinutes(1);

    }


}
