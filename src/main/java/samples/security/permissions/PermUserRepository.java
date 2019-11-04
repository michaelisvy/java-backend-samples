package samples.security.permissions;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PermUserRepository extends CrudRepository <PermUser, Long> {

    @Override
    Optional<PermUser> findById(Long id);

    @Query("from PermUser u join fetch u.roleList r join fetch r.applicationList where u.id=:id")
    Optional<PermUser> findByIdWithRolesAndApplications(Long id);
}
