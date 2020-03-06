package samples.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class LogAspectTest {
    @Autowired
    private AopCustomerService customerService;

    @Test
    public void shouldReturnBob() {
        String name = this.customerService.findName();
        assertThat(name).isEqualTo("Sam");
    }
}
