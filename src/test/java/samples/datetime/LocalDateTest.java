package samples.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class LocalDateTest {

    @Test
    public void shouldBeGreater() {
        LocalDate today = getCurrentDate();
        LocalDate yesterday = getDateOneDayAgo();

        assertThat(yesterday).isBefore(today);

    }

    private LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    private LocalDate getDateOneDayAgo() {
        return getCurrentDate().minusDays(1);

    }


}
