package kg.kgiai.hackathon.timetable.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    @Embedded
    private PersonInfo personInfo;
    @ManyToOne()
    @JoinColumn(name = "group_id")
    private Gruppa gruppa;

    @OneToMany(mappedBy = "student")
    private List<Mark> marks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return personInfo.getName();
    }

    public void setName(String name) {
        personInfo.setName(name);
    }


    public String getSurname() {
        return personInfo.getSurname();
    }

    public void setSurname(String surname) {
        personInfo.setSurname(surname);
    }


    public String getMiddleName() {
        return personInfo.getMiddleName();
    }

    public void setMiddleName(String middleName) {
        personInfo.setMiddleName(middleName);
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
}
