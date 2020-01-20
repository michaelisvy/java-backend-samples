package samples.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;

@SpringBootTest
@Transactional
public class VArtistRepositoryTest {
    @Autowired
    private VArtistRepository artistRepository;

    @Test
    public void shouldShowThatValidationHappensBeforeSavingToDB() {
        VArtist artist = new VArtist("Joe");
        Assertions.assertThrows(
                    ConstraintViolationException.class,
                    () -> { this.artistRepository.save(artist);} );


    }
}
