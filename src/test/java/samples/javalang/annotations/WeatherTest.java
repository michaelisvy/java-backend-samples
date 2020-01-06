package samples.javalang.annotations;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class WeatherTest {

    @Test
    public void shouldCreateWeather() {
        Weather weather = new Weather();
        weather.setToday(LocalDate.now());
    }

    @Test
    public void shouldCreateWeather2() {
        Weather2 weather = new Weather2();
        weather.setToday(LocalDate.now());
    }
}
