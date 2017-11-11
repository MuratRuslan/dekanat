package kg.kgiai.dekanat.rest_api.controller;

import kg.kgiai.dekanat.rest_api.model.Gruppa;
import kg.kgiai.dekanat.rest_api.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("groups")
@CrossOrigin(value = "http://localhost:4200")
public class GroupRestController extends AbstractRestController<Gruppa, Long> {

    @Autowired
    public GroupRestController(Service<Gruppa, Long> service) {
        super(service);
    }
}
