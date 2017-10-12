package kg.ksucta.hakathon.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MailingMicroServiceApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MailingMicroServiceApplication.class, args);
    }
}
