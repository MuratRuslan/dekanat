package kg.kgiai.hackathon.timetable.model;


import javax.persistence.*;
import java.util.List;

/**
 * Created by temirlan on 10/3/17.
 */
@Entity
public class Gruppa {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "gruppa")
    private List<Student> students;

    public Gruppa(){}

    public Gruppa(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
