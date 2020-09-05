package samples.spring.retry;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@Slf4j
@PropertySource("classpath:retry/retry-config.properties")
public class RetryableServiceAdvanced {

    @Retryable(value = CustomRetryException.class, maxAttemptsExpression = "#{@attemptsCalculator.maxAttempts}",
            backoff = @Backoff(delayExpression = "#{@attemptsCalculator.maxDelay}"))
    public void attemptBean(Counter counter) {
        counter.addAttempt();
        log.info(LocalTime.now().toString());
        throw new CustomRetryException();
    }

    @Retryable(value = CustomRetryException.class, maxAttemptsExpression = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "#{@attemptsCalculator.maxDelay}"))
    public void attemptProperties(Counter counter) {
        counter.addAttempt();
        log.info(LocalTime.now().toString());
        throw new CustomRetryException();
    }


    @Recover
    public void recover(CustomRetryException e, Counter counter) {
        counter.addRecovery();
        log.info(LocalTime.now().toString());
    }
}
