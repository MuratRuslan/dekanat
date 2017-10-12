package kg.ksucta.hakathon.mail.service;

/**
 * Created by temirlan on 10/13/17.
 */
public interface Generator<T, S, E> {
    T generate(S s, E e);

    T generate(S s);

}
