package samples.datetime;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.*;

public class ZonedDateTimeTest {
    public static final String ASIA_JAKARTA_TIMEZONE = "Asia/Jakarta";


    @Test
    public void shouldValidateTimeEqualityAccrossTimeZones() {
        assertThat(getShanghaiTime()).isEqualTo(getTokyoTime());
    }

    @Test
    public void shouldValidateThatDateisInBetween2Dates() {
        ZonedDateTime jakartaToday = ZonedDateTime.now(ZoneId.of(ASIA_JAKARTA_TIMEZONE));
        ZonedDateTime jakartaYesterday = jakartaToday.minusDays(1);

        assertThat(jakartaToday.withHour(8).withMinute(0).withSecond(0).withNano(0))
                .isBetween(
                        jakartaYesterday.withHour(15).withMinute(0).withSecond(0).withNano(1),
                        jakartaToday.withHour(8).withMinute(0).withSecond(0).withNano(0)
        );
    }

    private ZonedDateTime getShanghaiTime() {
        return ZonedDateTime.of(2018, 12, 11, 5, 5, 5, 0, ZoneId.of("Asia/Shanghai"));
    }

    private ZonedDateTime getTokyoTime() {
        return ZonedDateTime.of(2018, 12, 11, 6, 5, 5, 0, ZoneId.of("Asia/Tokyo"));
    }


}
