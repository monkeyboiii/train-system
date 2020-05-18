package train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import train.model.AjaxResponse;
import train.model.User;
import train.service.UserService;

import java.util.UUID;

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
    public AjaxResponse login(@RequestParam("value") String value,
                              @RequestParam("password") String password,
                              @RequestParam("credit") String credit) {

        User user = userService.queryUser(value);

        if (user == null) {
            return AjaxResponse.builder().status("NO").msg("No such user").build();
        } else {
            if (!user.getPassword().equals(password))
                return AjaxResponse.builder().status("No").msg("Wrong Password").build();
            else if (!user.getCredit().equals(credit))
                return AjaxResponse.builder().status("No").msg("No privilege").build();
            else {
                String token = UUID.randomUUID().toString();
                userService.postTokenByUsername(user.getUsername(), token);
                return AjaxResponse.builder()
                        .status("OK")
                        .msg("登录成功")
                        .username(user.getUsername())
                        .token(token)
                        .build();
            }
        }
    }

    @PostMapping("/logout")
    @ResponseBody
    public AjaxResponse logout(@RequestParam("username") String username) {
        userService.cleanTokenByUsername(username);
        return AjaxResponse.builder()
                .status("OK")
                .msg("您成功登出")
                .username(username)
                .build();
    }

}
