package kg.kgiai.dekanat.rest_api.controller;

import kg.kgiai.dekanat.rest_api.model.Timetable;
import kg.kgiai.dekanat.rest_api.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

public abstract class AbstractRestController<M, ID> {
    protected Service<M, ID> service;

    @Autowired
    public AbstractRestController(Service<M, ID> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<M>> getAll() {
        List<M> models = service.getAll();
        if (models.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<M>>(models, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<M> getById(@PathVariable ID id) {
        M model = service.getById(id);
        if (model == null) {
            return new ResponseEntity(new Exception("not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<M>(model, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody List<M> models) {
        if (models == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка целостности данных!");
        }
        service.save(models);
        return ResponseEntity.status(HttpStatus.OK).body("Успешно добавлен!");
    }
//    @PostMapping
//    public void save(@RequestBody String body) {
//        System.out.println(body);
//    }

    @PutMapping
    void save(@RequestBody M model) {
        service.save(model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }
}
