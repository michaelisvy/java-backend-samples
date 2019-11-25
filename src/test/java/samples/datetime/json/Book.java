package samples.datetime.json;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

public class Book {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime publishingTime;

    public ZonedDateTime getPublishingTime() {
        return publishingTime;
    }

    public void setPublishingTime(ZonedDateTime publishingTime) {
        this.publishingTime = publishingTime;
    }
}
