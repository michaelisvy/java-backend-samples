package samples.spring.retry;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetriableService {
    @Retryable(value = CustomRetryException.class, maxAttempts = 5)
    public void attempt(Counter counter) {
        counter.addAttempt();
        throw new CustomRetryException();
    }
    @Recover
    public void recover(CustomRetryException e, Counter counter) {
        counter.addRecovery();
    }
}
