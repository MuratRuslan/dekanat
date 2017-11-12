package kg.kgiai.dekanat.rest_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String day;

    @ManyToOne()
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ManyToMany
    @JoinTable(name = "lesson_room", joinColumns =
    @JoinColumn(name = "lesson_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id")
    )
    private List<Room> rooms;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Gruppa gruppa;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Gruppa getGruppa() {
        return gruppa;
    }

    public void setGruppa(Gruppa gruppa) {
        this.gruppa = gruppa;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
