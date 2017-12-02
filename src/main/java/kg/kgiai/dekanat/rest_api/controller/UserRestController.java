package kg.kgiai.dekanat.rest_api.controller;

import kg.kgiai.dekanat.rest_api.model.ApplicationUser;
import kg.kgiai.dekanat.rest_api.service.Service;
import kg.kgiai.dekanat.rest_api.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@CrossOrigin(value = "http://localhost:4200")
public class UserRestController extends AbstractRestController<ApplicationUser, Long> {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRestController(Service<ApplicationUser, Long> service) {
        super(service);
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        service.save(user);
    }
}
