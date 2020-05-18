package train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import train.model.User;
import train.service.UserService;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public String registerPage() {
        return "public/register";
    }


    @PostMapping("/register")
    @ResponseBody
    public int register(@RequestParam("username") String username,
                        @RequestParam("identity") String id,
                        @RequestParam("phone") String phone,
                        @RequestParam("password") String password,
                        @RequestParam("credit") String credit
    ) {
        return userService.insertUser(new User(username, id, phone, password, credit));
    }

}
