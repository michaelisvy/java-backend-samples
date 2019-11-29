package samples.datetime.clock;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.*;

public class ClockTest {

    private static final String CHRISTMAS_DATE = "2019-12-25T10:00:00Z";

    @Test
    public void shouldUseCurrentTime() {
        LocalDate date1 = LocalDate.now();

        Clock currentTimeClock = Clock.systemDefaultZone();
        LocalDate date2 = LocalDate.now(currentTimeClock);

        assertThat(date1).isEqualTo(date2);
    }

    @Test
    public void shouldUseChristmasTime() {
        Clock clock = Clock.fixed(Instant.parse(CHRISTMAS_DATE), ZoneOffset.UTC);
        LocalDate date = LocalDate.now(clock);
        assertThat(date.getDayOfMonth()).isEqualTo(25);
        assertThat(date.getMonthValue()).isEqualTo(12);
        assertThat(date.getYear()).isEqualTo(2019);
    }

}
