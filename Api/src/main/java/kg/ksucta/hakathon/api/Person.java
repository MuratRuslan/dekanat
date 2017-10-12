package kg.ksucta.hakathon.api;

import java.io.Serializable;

/**
 * Created by temirlan on 10/13/17.
 */
public class Person implements Serializable {
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
