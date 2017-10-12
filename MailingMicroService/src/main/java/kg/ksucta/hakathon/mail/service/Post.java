package kg.ksucta.hakathon.mail.service;

/**
 * Created by temirlan on 10/13/17.
 */
public interface Post<T> {
    boolean send(T t);
}
