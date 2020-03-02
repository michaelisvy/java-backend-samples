package samples.validation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class VArtistRepositoryTest {
    @Autowired
    private VArtistRepository artistRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void shouldShowThatValidationHappensBeforeSavingToDB() {
        VArtist artist = new VArtist("Joe");
        assertThrows(
                    ConstraintViolationException.class,
                    () -> { this.artistRepository.save(artist);} );


    }

    @Test
    public void shouldShowThatValidationCheckIsDoneForAnUpdate() {
        VArtist artist = new VArtist("Joe", "Smith");
        this.artistRepository.save(artist);
        this.entityManager.detach(artist);
        artist.setLastName("");
        assertThrows(
                ConstraintViolationException.class,
                () -> {
                    this.artistRepository.save(artist); // save is the method used for entity update
                    this.entityManager.flush();
                });
    }
}
