package com.veva.veva;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.veva.veva.User.controller.UserController;

@SpringBootTest
class VevaApplicationTests {

	@Autowired
	private UserController userController;

	//tests if application starts up by testing whether the userController bean isn't null
	@Test
	void contextLoads() throws Exception {
		assertThat(userController).isNotNull();
	}
}
