package train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import train.model.Order;
import train.model.Ticket;
import train.service.OrderService;
import train.service.TicketService;
import train.service.UserService;

import java.util.Collections;
import java.util.List;

/**
 * Handle order-ticket related business
 */
@Controller
@RequestMapping
public class OrderController {

    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    TicketService ticketService;


    @GetMapping("/order")
    public String orderPage(@RequestParam("username") String username,
                            @RequestParam("credit") String credit,
                            ModelMap modelMap) {

        String role = credit.equals("u") ?
                "user"
                :
                (credit.equals("a") ? "admin" : "tester");
        modelMap.addAttribute("role", role);
        modelMap.addAttribute("username", username);
        return "user/order";
    }


    @GetMapping("/order/{value}")
    @ResponseBody
    public List<Order> queryOrder(@PathVariable String value,
                                  @RequestParam(value = "status", defaultValue = "all") String status) {
        Integer user_id = userService.getUserId(value);
        if (user_id == null) return Collections.emptyList();
        return orderService.queryOrdersByUserId(user_id, status.toLowerCase());
    }

}