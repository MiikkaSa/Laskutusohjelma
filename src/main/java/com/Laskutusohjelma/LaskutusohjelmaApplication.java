package com.Laskutusohjelma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.Laskutusohjelma.domain.AppUser;
import com.Laskutusohjelma.domain.AppUserRepository;


@SpringBootApplication
public class LaskutusohjelmaApplication {
	 private static final Logger log = LoggerFactory.getLogger(LaskutusohjelmaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(LaskutusohjelmaApplication.class, args);
	}

	@Bean
    public CommandLineRunner userDemo(AppUserRepository urepository) {
        return (args) -> {
        	log.info("käyttäjä");
        	AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
	
	log.info("fetch all users");
	for (AppUser appUser : urepository.findAll()) {
		log.info(appUser.toString());
	}
        };
	}
}


