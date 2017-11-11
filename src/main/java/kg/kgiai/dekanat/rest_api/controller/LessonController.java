package kg.kgiai.dekanat.rest_api.controller;

import kg.kgiai.dekanat.rest_api.service.services.LessonService;
import kg.kgiai.dekanat.rest_api.model.Timetable;
import kg.kgiai.dekanat.rest_api.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lessons")
@CrossOrigin(value = "http://localhost:4200")
public class LessonController extends AbstractController<Timetable, Long> {

    @Autowired
    public LessonController(Service<Timetable, Long> service) {
        super(service);
    }

    @GetMapping("/day/{weekday}")
    public ResponseEntity<List<Timetable>> getAllByDay(@PathVariable String weekday) {
        List<Timetable> lessons = ((LessonService)service).getAllByDay(weekday);
        if( lessons.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Timetable>>(lessons, HttpStatus.OK);
    }
}
