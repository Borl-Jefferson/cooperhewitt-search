package org.jointheleague.cooperhewitt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CooperhewittApplication {

	public static void main(String[] args) {
		System.out.println("web thing about to be running");
		SpringApplication.run(CooperhewittApplication.class, args);
        System.out.println("web thing should be running at: http://localhost:5000");
	}

}
