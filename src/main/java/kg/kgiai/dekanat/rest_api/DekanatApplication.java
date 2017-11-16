package kg.kgiai.dekanat.rest_api;

import kg.kgiai.dekanat.rest_api.model.Gruppa;
import kg.kgiai.dekanat.rest_api.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@CrossOrigin(value = "http://localhost:4200")
public class DekanatApplication {

	public static void main(String[] args) {
		SpringApplication.run(DekanatApplication.class, args);
	}
}
