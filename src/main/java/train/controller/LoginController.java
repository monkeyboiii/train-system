package train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import train.model.User;
import train.service.UserService;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "public/login";
    }


    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam("value") String value,
                        @RequestParam("password") String password,
                        @RequestParam("credit") String credit) {

        User user = userService.queryUser(value);

        if (user == null) {
            return "No Such User";
        } else {
            if (!user.getPassword().equals(password))
                return "Wrong password";
            else if (!user.getCredit().equals(credit))
                return "No privilege";
            else
                return "r" + user.getCredit() + user.getUsername();
        }

    }


}
