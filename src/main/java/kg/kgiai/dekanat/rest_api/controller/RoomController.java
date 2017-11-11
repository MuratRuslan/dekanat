package kg.kgiai.dekanat.rest_api.controller;

import kg.kgiai.dekanat.rest_api.model.Room;
import kg.kgiai.dekanat.rest_api.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rooms")
@CrossOrigin(value = "http://localhost:4200")
public class RoomController extends AbstractController<Room, Integer> {

    @Autowired
    public RoomController(Service<Room, Integer> service) {
        super(service);
    }
}
