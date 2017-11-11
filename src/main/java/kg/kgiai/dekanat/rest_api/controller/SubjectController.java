package kg.kgiai.dekanat.rest_api.controller;

import kg.kgiai.dekanat.rest_api.model.Subject;
import kg.kgiai.dekanat.rest_api.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subjects")
@CrossOrigin(value = "http://localhost:4200")
public class SubjectController extends AbstractController<Subject, Integer> {

    @Autowired
    public SubjectController(Service<Subject, Integer> service) {
        super(service);
    }
}
