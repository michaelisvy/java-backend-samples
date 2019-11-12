package samples.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.*;

public class ZonedDateTimeTest {

    @Test
    public void shouldValidateTimeEqualityAccrossTimeZones() {
        assertThat(getShanghaiTime()).isEqualTo(getTokyoTime());

    }

    private ZonedDateTime getShanghaiTime() {
        return ZonedDateTime.of(2018,12,11,5,5,5,0, ZoneId.of("Asia/Shanghai"));
    }

    private ZonedDateTime getTokyoTime() {
        return ZonedDateTime.of(2018,12,11,6,5,5,0, ZoneId.of("Asia/Tokyo"));
    }




}
