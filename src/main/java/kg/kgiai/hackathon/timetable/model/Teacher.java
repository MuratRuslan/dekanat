package kg.kgiai.hackathon.timetable.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private PersonInfo personInfo;
    @ManyToMany
    @JoinTable(name = "Subject_Teacher", joinColumns =
    @JoinColumn(name = "subject_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    )
    private List<Subject> subjects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
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
}
