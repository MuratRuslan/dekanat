package kg.ksucta.hakathon.mail.service.impl;

import kg.ksucta.hakathon.api.MailMessage;
import kg.ksucta.hakathon.mail.model.Server;
import kg.ksucta.hakathon.mail.service.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Created by temirlan on 10/13/17.
 */
@Service
public class MailService implements Post<MailMessage> {
    @Autowired
    private JavaMailSenderGeneratorService javaMailSenderGeneratorService;

    @Override
    public boolean send(MailMessage mailMessage) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailMessage.getReceiver().getEmail());
        simpleMailMessage.setText(mailMessage.getText());
        simpleMailMessage.setSubject(mailMessage.getHeader());
        javaMailSenderGeneratorService.generate(Server.GMAIL, mailMessage.getSender()).send(simpleMailMessage);
        return false;
    }
}
