package samples.solid.openclose.good;

import org.junit.jupiter.api.Test;
import samples.solid.openclose.good.OCGPersonalAccount;

import static org.assertj.core.api.Assertions.*;

public class OCGAccountTest {
    @Test
    public void shouldCalculatePersonalAccountInterest() {
        OCGPersonalAccount account = new OCGPersonalAccount(1, "current account", 1000);
        assertThat(account.calculateMonthlyInterest()).isEqualTo(1000*0.03/12);
    }
}
