package samples.spring.retry;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service("attemptsCalculator")
public class AttemptsCalculator {

    public int getMaxAttempts() {
        LocalTime noonTime = LocalTime.of(12,00);
        if (LocalTime.now().isBefore(noonTime))
            return 2;
        else return 1;
    }
}
