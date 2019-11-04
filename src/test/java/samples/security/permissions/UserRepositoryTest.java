package samples.security.permissions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

@TransactionalTest
class UserRepositoryTest {

	@Autowired
	private PermUserRepository userRepository;

	public PermUser buildAndSaveUser() {
		PermRole role1 = new PermRole("admin");
		role1.addApplication(new PermApplication("pph21"));
		role1.addApplication(new PermApplication("ppn"));

		PermUser user = new PermUser("John");
		user.addRole(role1);
		this.userRepository.save(user);
		return user;
	}

	@Test
	void shouldFindUserWithRoles() {
		Long id = buildAndSaveUser().getId();
		PermUser retrievedUser = this.userRepository.findByIdWithRolesAndApplications(id).get();
		assertThat(retrievedUser.getId()).isNotNull();
	}

	@Test
	void shouldFindUserWithRoles2() {
		Long id = buildAndSaveUser().getId();
		PermUser retrievedUser = this.userRepository.findByIdWithRolesAndApplications(id).get();
		assertThat(retrievedUser.getId()).isNotNull();
	}

}
