package train.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import train.model.User;
import train.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PutMapping("/users") // Create
    public int insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    /*@PutMapping("/users") // Create
    public User insertUser(@RequestParam("username") String username,
                           @RequestParam("id") String id,
                           @RequestParam("phone") String phone,
                           @RequestParam("password") String password) {
        User user = User.builder().
                username(username).
                id(id).
                phone(phone).
                password(password).build();
        System.out.println("user.toString() = " + user.toString());
        System.out.println("user = " + user);
        return insertUser(user);
    }*/


    @GetMapping("/users/{value}") // Supports username, id, phone
    public User queryUser(@PathVariable String value) {
        return userService.queryUser(value);
    }

    @PostMapping("/users/{value}") // value = field, can only update password
    public int updateUser(@PathVariable String value,
                           @RequestParam("password") String password) {
        return userService.updateUser(value,password);
    }

    @DeleteMapping("/Users/{value}") // Supports username, id, phone
    public int deleteUser(@PathVariable String value) {
        return userService.deleteUser(value);
    }

}