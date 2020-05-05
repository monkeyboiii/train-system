package train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import train.model.Order;
import train.model.Ticket;
import train.service.OrderService;
import train.service.UserService;

import java.util.Collections;
import java.util.List;

/**
 * Handle order-ticket related business
 */
@RequestMapping
@RestController
public class OrderController {

    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;


    @PutMapping("/orders/{value}") // TODO: Generate order
    public Ticket createOrderAndTicket(@PathVariable String value,
                                       @RequestParam("route_id") String route_id,
                                       @RequestParam("date") String date) {
        Integer user_id = userService.getUserId(value);
        if (user_id == null) return null;

        return null;
    }


    @GetMapping("/orders/{value}")
    public List<Order> queryOrder(@PathVariable String value,
                                  @RequestParam(value = "status", defaultValue = "all") String status) {
        Integer user_id = userService.getUserId(value);
        if (user_id == null) return Collections.emptyList();
        return orderService.queryOrdersByUserId(user_id, status.toLowerCase());
    }

}