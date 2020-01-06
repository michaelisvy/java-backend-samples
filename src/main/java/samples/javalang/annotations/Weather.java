package samples.javalang.annotations;

import java.time.LocalDate;

public class Weather {

    @UseAnywhere
    private LocalDate today;

    @UseAnywhere
    public void setToday(LocalDate today) {
        this.today = today;
    }
}
