package kg.kgiai.dekanat.rest_api.controller;

import kg.kgiai.dekanat.rest_api.model.Student;
import kg.kgiai.dekanat.rest_api.service.Service;
import kg.kgiai.dekanat.rest_api.service.services.StudentService;
import kg.kgiai.dekanat.rest_api.service.services.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@CrossOrigin(value = "http://localhost:4200")
public class StudentRestController extends AbstractRestController<Student, Long> {

    @Autowired
    public StudentRestController(Service<Student, Long> service) {
        super(service);
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<?> getStudentsByGroupId(@PathVariable Long id) {
        List<Student> all = ((StudentService) service).getAllByGroupId(id);
        if(all.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Для данной группы нет студентов!");
        }
        return new ResponseEntity(all, HttpStatus.OK);
    }

    @GetMapping("/{group}/{semester}")
    public ResponseEntity<List<Student>> getStudentsMarksByGroupIdAndSemesterId(@PathVariable() Long group, @PathVariable() Long semester) {
        List<Student> students = ((StudentServiceImpl) service).getStudentMarksByGroupIdAndSemesterId(group, semester);
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }
}
