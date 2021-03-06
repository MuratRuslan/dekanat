package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.Room;
import kg.kgiai.dekanat.rest_api.model.Teacher;
import kg.kgiai.dekanat.rest_api.repository.LessonRepository;
import kg.kgiai.dekanat.rest_api.service.services.AbstractService;
import kg.kgiai.dekanat.rest_api.service.services.LessonService;
import kg.kgiai.dekanat.rest_api.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.NotSupportedException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LessonServiceImpl extends AbstractService<Lesson, Long> implements LessonService {

    @Autowired
    public LessonServiceImpl(JpaRepository<Lesson, Long> repository) {
        super(repository);
    }

    @Override
    public Lesson getByName(String name) throws NotSupportedException {
        throw new NotSupportedException();
    }

    @Override
    public List<Lesson> getAllByDay(String weekday) {
        return ((LessonRepository)repository).findByDay(weekday);
    }

    @Override
    public boolean isAcceptable(Lesson lesson) {
        List<Lesson> all = ((LessonRepository) repository).findByDayAndTime(lesson.getDay(), lesson.getTime());
        return teacherValid(lesson, all) && roomValid(lesson, all);
    }

    private boolean roomValid(Lesson lesson, List<Lesson> all) {
        for(Lesson current : getLessonsContainingRooms(all, lesson.getRooms())) {
            if(current.getGruppa().getId().equals(lesson.getGruppa().getId())
                    && lesson.isDenominator() != current.isDenominator()) {
                continue;
            }
            if(!current.getGruppa().getStartYear().equals(lesson.getGruppa().getStartYear()) && containsRooms(lesson, current)) {
                return false;
            }
            if(!current.getSubject().getId().equals(lesson.getSubject().getId())) {
                return false;
            }
        }
        return true;
    }

    private boolean teacherValid(Lesson lesson, List<Lesson> all) {
        for(Lesson current : getLessonsContainingTeachers(all, lesson.getTeachers())) {
            if(current.getGruppa().getId().equals(lesson.getGruppa().getId())
                    && lesson.isDenominator() != current.isDenominator()) {
                continue;
            }
            if(!current.getGruppa().getStartYear().equals(lesson.getGruppa().getStartYear())){
                return false;
            }
            if(!current.getSubject().getId().equals(lesson.getSubject().getId())) {
                return false;
            }
            if(current.getType().equals("ПР")) {
                return false;
            }
        }
        return true;
    }

    private boolean containsTeacher(Lesson lesson, Teacher teacher) {
        for(Teacher current: lesson.getTeachers()) {
            if(current.getId().equals(teacher.getId())) {
                return true;
            }
        }
        return false;
    }

    private boolean containsRoom(Lesson lesson, Room room) {
        for(Room current: lesson.getRooms()) {
            if(current.getId().equals(room.getId())) {
                return true;
            }
        }
        return false;
    }

    private boolean containsRooms(Lesson lesson, Lesson currentLesson) {
        for(Room room : lesson.getRooms()) {
             if(containsRoom(currentLesson, room)) {
                 return true;
             }
        }
        return false;
    }

    private List<Lesson> getLessonsContainingRooms(List<Lesson> lessons, List<Room> rooms) {
        List<Lesson> result = new ArrayList<>();
        for(Lesson currentLesson : lessons) {
            for(Room room: rooms) {
                if(containsRoom(currentLesson, room)) {
                    result.add(currentLesson);
                }
            }
        }
        return result;
    }

    private List<Lesson> getLessonsContainingTeachers(List<Lesson> lessons, List<Teacher> teachers) {
        List<Lesson> result = new ArrayList<>();
        for(Lesson currentLesson : lessons) {
            for(Teacher teacher: teachers) {
                if(containsTeacher(currentLesson, teacher)) {
                    result.add(currentLesson);
                }
            }
        }
        return result;
    }
}
