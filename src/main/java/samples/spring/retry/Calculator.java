package samples.spring.retry;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service("attemptsCalculator")
public class Calculator {
    private boolean isMorning() {
        LocalTime noonTime = LocalTime.of(12,00);
        if (LocalTime.now().isBefore(noonTime))
            return true;
        else return false;
    }

    public int getMaxAttempts() {
        if (isMorning())
            return 2;
        else return 1;
    }

    public int getMaxDelay() {
        if (isMorning())
            return 200;
        else return 100;
    }
}
