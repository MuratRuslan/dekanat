package kg.kgiai.dekanat.rest_api.controller;

import kg.kgiai.dekanat.rest_api.model.Teacher;
import kg.kgiai.dekanat.rest_api.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teachers")
@CrossOrigin(value = "http://localhost:4200")
public class TeacherController extends AbstractController<Teacher, Long>{

    @Autowired
    public TeacherController(Service<Teacher, Long> service) {
        super(service);
    }
}
