package kg.kgiai.dekanat.rest_api.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import kg.kgiai.dekanat.rest_api.json.custom.CustomMarkDeserializer;
import kg.kgiai.dekanat.rest_api.json.custom.CustomMarkSerializer;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne()
    @JsonSerialize(using = CustomMarkSerializer.class)
    @JsonDeserialize(using = CustomMarkDeserializer.class)
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne()
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne()
    @JoinColumn(name = "semester_id")
    private Semester semester;
    @ElementCollection
    @CollectionTable(name = "mark_attempts", joinColumns = @JoinColumn(name = "mark_id"))
    @Column(name = "mark")
    private List<Float> marks;

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

    public List<Float> getMarks() {
        return marks;
    }

    public void setMarks(List<Float> mark) {
        this.marks = mark;
    }

}
