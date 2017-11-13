package kg.kgiai.dekanat.rest_api.controller;

import kg.kgiai.dekanat.rest_api.model.Semester;
import kg.kgiai.dekanat.rest_api.service.Service;
import kg.kgiai.dekanat.rest_api.service.services.SemesterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("semesters")
@CrossOrigin(value = "http://localhost:4200")
public class SemesterRestController extends AbstractRestController<Semester, Long> {
    public SemesterRestController(Service<Semester, Long> service) {
        super(service);
    }

    @PostMapping
    @Override
    public ResponseEntity save(@RequestBody List<Semester> models) {
        for (Semester semester : models) {
            if (((SemesterService) service).exist(semester)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Этот семестр существует!");
            }
        }
        return super.save(models);
    }
}
