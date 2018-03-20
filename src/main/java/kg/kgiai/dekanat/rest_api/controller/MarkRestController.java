package kg.kgiai.dekanat.rest_api.controller;

import kg.kgiai.dekanat.rest_api.model.Mark;
import kg.kgiai.dekanat.rest_api.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("marks")
@CrossOrigin(value = "http://localhost:4200")
public class MarkRestController extends AbstractRestController<Mark, Long> {

    private float minMarkToPassExam = 2.6f;

    @Autowired
    public MarkRestController(Service<Mark, Long> service) {
        super(service);
    }


    @Override
    public ResponseEntity save(@RequestBody List<Mark> models) {
        return super.save(models);
    }

    @Override
    void save(@RequestBody Mark model) {
        super.save(model);
    }
}
