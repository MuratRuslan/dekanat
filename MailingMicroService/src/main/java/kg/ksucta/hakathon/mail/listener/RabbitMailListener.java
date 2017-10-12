package kg.ksucta.hakathon.mail.listener;

import kg.ksucta.hakathon.api.MailMessage;
import kg.ksucta.hakathon.mail.config.RabbitConfiguration;
import kg.ksucta.hakathon.mail.service.impl.MailService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by temirlan on 10/13/17.
 */
@EnableRabbit
@Component
public class RabbitMailListener {

    @Autowired
    private MailService mailService;

    @RabbitListener(queues = "simple-message")
    public void simpleMessage(String message) {
        System.out.println(message);
    }

    @RabbitListener(queues = RabbitConfiguration.MESSAGE_OBJECT_QUEUE)
    public void messageObjectListener(MailMessage message){
        mailService.send(message);
    }
}