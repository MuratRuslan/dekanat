package kg.kgiai.dekanat.rest_api.controller;

import kg.kgiai.dekanat.rest_api.service.services.LessonService;
import kg.kgiai.dekanat.rest_api.model.Lesson;
import kg.kgiai.dekanat.rest_api.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("lessons")
@CrossOrigin(value = "http://localhost:4200")
public class LessonRestController extends AbstractRestController<Lesson, Long> {

    @Autowired
    public LessonRestController(Service<Lesson, Long> service) {
        super(service);
    }

    @GetMapping("/day/{weekday}")
    public ResponseEntity<List<Lesson>> getAllByDay(@PathVariable String weekday) {
        List<Lesson> lessons = ((LessonService)service).getAllByDay(weekday);
        if( lessons.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Lesson>>(lessons, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity save(@RequestBody List<Lesson> models) {
        if (models == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Ошибка");
        }
        for(Lesson lesson : models) {
            lesson.setTime(new Date(lesson.getTime().getTime() - 21600 * 1000));
            if ( !((LessonService)service).isAcceptable(lesson)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Аудитория или преподователь уже заняты!");
            }
        }
        service.save(models);
        return ResponseEntity.status(HttpStatus.OK).body("Успешно добавлен!");
    }


}
