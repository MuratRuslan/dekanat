package kg.ksucta.hakathon.api;

import java.io.Serializable;

/**
 * Created by temirlan on 10/13/17.
 */
public class MailMessage implements Serializable{
    private Person sender;
    private Person receiver;
    private String header;
    private String text;

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getReceiver() {
        return receiver;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
