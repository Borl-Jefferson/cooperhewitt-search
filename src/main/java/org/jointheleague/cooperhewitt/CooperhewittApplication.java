package org.jointheleague.cooperhewitt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CooperhewittApplication {

	public static void main(String[] args) {
		SpringApplication.run(CooperhewittApplication.class, args);
        System.out.print("web thing should be running");
	}

}
