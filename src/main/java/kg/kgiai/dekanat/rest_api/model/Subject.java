package kg.kgiai.dekanat.rest_api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Subject {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
