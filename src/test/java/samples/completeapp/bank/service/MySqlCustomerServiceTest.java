package samples.completeapp.bank.service;

import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.springframework.test.context.ActiveProfiles;

@EnabledOnOs({OS.WINDOWS, OS.MAC})
@ActiveProfiles("mysql")
public class MySqlCustomerServiceTest extends CustomerServiceTest {
}
