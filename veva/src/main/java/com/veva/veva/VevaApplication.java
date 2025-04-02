package com.veva.veva;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.veva.veva.User.model.Origin;
import com.veva.veva.User.model.User;
import com.veva.veva.User.repository.UserRepository;

@SpringBootApplication
public class VevaApplication {

	@Autowired
	private static UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(VevaApplication.class, args);

		System.out.println("Testing database----------------------");
		User newUser = new User("testing", "testing@someemail", "hello", Origin.HUMAN);
		userRepository.save(newUser);

		System.out.println("Adding user------------------");
		List<User> users = userRepository.getAll();
		users.forEach(System.out::println);

		System.out.println("Adding another");
		User secondUser = new User("2nd", "2nd email", "2nd pass", Origin.FOREST_ELF);

		users = userRepository.getAll();
		users.forEach(System.out::println);

		System.out.println("Updating a user --------------");
		newUser.setPassword("new password!!");
		newUser.setUsername("new username");
		newUser.setOrigin(Origin.MAGE);

		userRepository.updateById(newUser, newUser.getUserId());

		users = userRepository.getAll();
		users.forEach(System.out::println);

		System.out.println("Deleting the user -----------------------");
		userRepository.deleteById(secondUser.getUserId());

		users = userRepository.getAll();
		users.forEach(System.out::println);
	}

}
