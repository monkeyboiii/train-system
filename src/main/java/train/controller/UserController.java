package train.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import train.model.Order;
import train.model.User;
import train.service.OrderService;
import train.service.UserService;

import java.util.List;

/**
 * Controls the behavior of a client's user-requests,
 * including basic user-related CRUD, plus create/modify/delete orders.
 * <p>
 * The parameter value supports username, id, phone.
 */
@RestController
@RequestMapping
public class UserController {

    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;


    @GetMapping("/users/{value}/orders") // See all orders
    public List<Order> queryOrder(@PathVariable String value) {
        Integer user_id = userService.getUserId(value);
        return orderService.queryOrdersByUserId(user_id);
    }


    @PutMapping("/users/{value}/orders") // Generate order
    public int createOrder(@PathVariable String value) {
        Integer user_id = userService.getUserId(value);
        return orderService.createOrderForUserId(user_id);
    }


    @PutMapping("/users")
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


    /**
     * Supports get user_id from provided username, id or phone,
     * returns null if non-existing
     */
    @GetMapping("/users/{value}")
    public User queryUser(@PathVariable String value) {
        return userService.queryUser(value);
    }


    @PostMapping("/users/{value}") // Can only update password
    public int updateUser(@PathVariable String value,
                          @RequestParam("password") String password) {
        return userService.updateUser(value, password);
    }


    @DeleteMapping("/users/{value}")
    public int deleteUser(@PathVariable String value) {
        return userService.deleteUser(value);
    }

}