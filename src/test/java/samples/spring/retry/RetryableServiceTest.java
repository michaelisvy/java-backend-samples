package samples.spring.retry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import samples.annotation.OPServiceTest;

import static org.assertj.core.api.Assertions.*;

@OPServiceTest
public class RetryableServiceTest {
    @Autowired
    private RetryableService retriableService;

    @Test
    public void shouldRetry() {
        Counter counter = new Counter();
        this.retriableService.attempt(counter);
        assertThat(counter.getAttempts()).isEqualTo(2);
        assertThat(counter.getRecoveries()).isEqualTo(1);
    }

}
