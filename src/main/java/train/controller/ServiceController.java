package train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import train.service.UserService;

/**
 * Privilege control
 */
@Controller
public class ServiceController {

    @Autowired
    UserService userService;


    @GetMapping("/service/order")
    public String orderPageRedirect(@RequestParam("username") String username,
                                    @RequestParam("credit") String credit,
                                    @RequestParam("token") String token,
                                    Model model) {
        if (userService.confirmTokenByUsername(username, token) == null) {
            return "public/failed";
        }

        String role = translateRole(credit);
        model.addAttribute("role", role);
        model.addAttribute("username", username);
        model.addAttribute("token", token);
        return switch (role) {
            case "user" -> "user/order";
            case "admin" -> "admin/manage";
            case "tester" -> "tester/test";
            default -> "public/failed";
        };
    }


    @GetMapping(value = {"/service/route", "/service"})
    public String RoutePageRedirect(@RequestParam("username") String username,
                                    @RequestParam("credit") String credit,
                                    @RequestParam("token") String token,
                                    Model model
    ) {
        if (userService.confirmTokenByUsername(username, token) == null) {
            return "public/failed";
        }

        String role = translateRole(credit);
        model.addAttribute("role", role);
        model.addAttribute("username", username);
        model.addAttribute("token", token);
        return switch (role) {
            case "user" -> "user/route";
            case "admin" -> "admin/manage";
            case "tester" -> "tester/test";
            default -> "public/failed";
        };
    }


    private static String translateRole(String credit) {
        if (credit.length() == 1)
            return credit.equals("u") ?
                    "user"
                    :
                    (credit.equals("a") ? "admin" : "tester");
        else return credit.toLowerCase();
    }

}
