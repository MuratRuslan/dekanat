package kg.kgiai.dekanat.rest_api.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String middleName;
    @ManyToOne()
    @JoinColumn(name = "group_id")
    private Gruppa gruppa;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Mark> marks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Gruppa getGruppa() {
        return gruppa;
    }

    public void setGruppa(Gruppa gruppa) {
        this.gruppa = gruppa;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return getName();
    }
}
