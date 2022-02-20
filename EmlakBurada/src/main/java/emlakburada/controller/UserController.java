package emlakburada.controller;

import emlakburada.model.dto.User;
import emlakburada.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/findAllUser")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll() {
        return userService.findAllUser();
    }

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public User findByEmail(@PathVariable String email) throws Exception {
        return userService.findByEmail(email);
    }

}
