package samples.solid.openclose.bad;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OCBAccountTest {
    @Test
    public void shouldCalculatePersonalAccountInterest() {
        OCBAccount account = new OCBAccount(1, "current account", 1000, AccountType.PERSONAL_ACCOUNT);
        assertThat(account.calculateMonthlyInterest()).isEqualTo(1000 * 0.03 / 12);
    }
}
