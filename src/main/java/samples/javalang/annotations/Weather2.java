package samples.javalang.annotations;

import java.time.LocalDate;

/**
 * shows that target scope is inherited
 */
@UseAnywhereWithType
public class Weather2 {

    @UseAnywhereWithType
    private LocalDate today;

    @UseAnywhereWithType
    public void setToday(LocalDate today) {
        this.today = today;
    }
}
