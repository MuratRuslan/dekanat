package kg.kgiai.dekanat.rest_api.controller;

import kg.kgiai.dekanat.rest_api.model.Student;
import kg.kgiai.dekanat.rest_api.service.Service;
import kg.kgiai.dekanat.rest_api.service.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
@CrossOrigin(value = "http://localhost:4200")
public class StudentRestController extends AbstractRestController<Student, Long> {

    @Autowired
    public StudentRestController(Service<Student, Long> service) {
        super(service);
    }
}
