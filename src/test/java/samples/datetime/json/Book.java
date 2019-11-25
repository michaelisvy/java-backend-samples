package samples.datetime.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Data
public class Book {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime publishingTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishingDate;
}
