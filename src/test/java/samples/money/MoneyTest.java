package samples.money;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;


public class MoneyTest {

    @Test
    public void shouldSumBigDecimals() {
        BigDecimal number1 = new BigDecimal(12.001);
        BigDecimal number2 = new BigDecimal(1);
        number1 = number1.add(number2);
        assertThat(number1).isEqualTo(new BigDecimal(13.001));
    }

    @Test
    public void sampleFromInternet() {
        double a = 0.02;
        double b = 0.03;
        double c = b - a;
        System.out.println(c);

        BigDecimal _a = new BigDecimal("0.02");
        BigDecimal _b = new BigDecimal("0.03");
        BigDecimal _c = _b.subtract(_a);
        System.out.println(_c);
    }
}
