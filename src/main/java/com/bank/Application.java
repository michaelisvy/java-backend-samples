package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@SpringBootApplication
public class Application {

	public static final String DEFAULT_PROFILE_NAME = "h2";

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		assignDefaultProfile(args, application);

		SpringApplication.run(Application.class);
	}

	private static void assignDefaultProfile(String[] args, SpringApplication application) {
		SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
		if (!springProfileHasBeenDefined(source)) {
			application.setAdditionalProfiles(DEFAULT_PROFILE_NAME);
		}
	}

	private static boolean springProfileHasBeenDefined(SimpleCommandLinePropertySource source) {
		return source.containsProperty("spring.profiles.active") &&
				System.getenv().containsKey("SPRING_PROFILES_ACTIVE");
	}
}