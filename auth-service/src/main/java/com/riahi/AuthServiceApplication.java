package com.riahi;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.riahi.entities.AppUser;
import com.riahi.service.AccountService;

//@EnableDiscoveryClient
@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
}

@Configuration
class InjectData implements CommandLineRunner {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Autowired
	AccountService accountService ;
	
	@Override
	public void run(String... args) throws Exception {

		Stream.of("adminCat , 1234 " , "adminProd, 1234 ")
		.map(s-> s.split(" , "))
		.forEach(tup -> accountService.saveUser(new AppUser(null ,tup[0], tup[1] , null)));
		
		System.out.println("=======================================");
		accountService.listUser()
		.forEach(u-> System.out.println(u.getUsername()));
		System.out.println("=======================================");
		
	}
	
}