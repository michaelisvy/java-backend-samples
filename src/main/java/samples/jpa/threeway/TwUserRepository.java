package samples.jpa.threeway;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TwUserRepository extends CrudRepository<TwUser, Long> {

    @Override
    Optional<TwUser> findById(Long id);
}
