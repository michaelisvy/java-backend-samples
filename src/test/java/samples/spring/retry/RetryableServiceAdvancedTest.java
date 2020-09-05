package samples.spring.retry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import samples.annotation.OPServiceTest;

import static org.assertj.core.api.Assertions.*;

@OPServiceTest
public class RetryableServiceAdvancedTest {
    @Autowired
    private RetryableServiceAdvanced retriableService;

    @Test
    public void shouldRetryUsingConfigFromPropertiesFile() {
        Counter counter = new Counter();
        this.retriableService.attemptProperties(counter);
        assertThat(counter.getAttempts()).isIn(1,2);
        assertThat(counter.getRecoveries()).isEqualTo(1);
    }

    @Test
    public void shouldRetryUsingConfigFromBean() {
        Counter counter = new Counter();
        this.retriableService.attemptBean(counter);
        assertThat(counter.getAttempts()).isIn(1,2);
        assertThat(counter.getRecoveries()).isEqualTo(1);
    }

}
