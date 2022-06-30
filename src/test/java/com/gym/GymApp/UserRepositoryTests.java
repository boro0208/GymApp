package com.gym.GymApp;

import com.gym.GymApp.model.User;
import com.gym.GymApp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	@Autowired
	private UserRepository repository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setName("Test");
		user.setSurname("Test");
		user.setPassword("12345");
		user.setEmail("test.test@gmail.com");
		user.setMobilePhone("060/121111");
		user.setAddress("Test 656");
		user.setCity("Test");
		user.setZip(2234);
		user.setGender("Male");
		user.setStatus("Active");
		user.setDateOfBirth("01.01.1971");
		user.setCreationDate("28.06.2022");
		user.setLoyCard("0000000000000000001");
		user.setUserCreated(1);

		User savedUser = repository.save(user);

		User existUser = entityManager.find(User.class, savedUser.getId());

		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}

	@Test
	public void testFindUserByEmail() {
		String email = "bororadojcic1991@gmail.com";

		User user = repository.findByEmail(email);
		assertThat(user).isNotNull();
	}
}
