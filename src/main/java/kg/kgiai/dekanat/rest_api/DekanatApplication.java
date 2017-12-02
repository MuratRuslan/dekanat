package kg.kgiai.dekanat.rest_api;

import kg.kgiai.dekanat.rest_api.model.Gruppa;
import kg.kgiai.dekanat.rest_api.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@CrossOrigin(value = "http://localhost:4200")
public class DekanatApplication {

	public static void main(String[] args) {
		SpringApplication.run(DekanatApplication.class, args);
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("ANONYMOUS"));
	}
}
