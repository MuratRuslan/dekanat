package kg.kgiai.dekanat.rest_api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Mark {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne()
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne()
    @JoinColumn(name = "semester_id")
    private Semester semester;
    @Column
    private Float mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }
}
