package kg.ksucta.hakathon.mail.service.impl;


import kg.ksucta.hakathon.api.Person;
import kg.ksucta.hakathon.mail.model.Server;
import kg.ksucta.hakathon.mail.service.Generator;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Created by temirlan on 10/13/17.
 */
@Service
public class JavaMailSenderGeneratorService implements Generator<JavaMailSender, Server, Person> {
    @Override
    public JavaMailSender generate(Server server, Person person) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        switch (server) {
            case GMAIL:
                mailSender.setHost("smtp.gmail.com");
            default:
                mailSender.setHost("smtp.gmail.com");
        }
        mailSender.setPort(587);
        mailSender.setUsername(person.getEmail());
        mailSender.setPassword(person.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }

    @Override
    public JavaMailSender generate(Server server) {
        return null;
    }
}
