package samples.spring.retry;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@Slf4j
public class RetriableServiceAdvanced {

    @Retryable(value = CustomRetryException.class, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public void attempt(Counter counter) {  
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
