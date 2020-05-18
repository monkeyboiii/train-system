package train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import train.model.Order;
import train.model.OrderPost;
import train.model.Ticket;
import train.service.OrderService;
import train.service.TicketService;
import train.service.UserService;

import java.util.Collections;

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


    @PostMapping("/order")
    @ResponseBody // Object and ResponseBody will parse json format
    public Object queryOrder(@RequestParam(value = "value") String value,
                             @RequestParam(value = "status", defaultValue = "all") String status) {
        Integer user_id = userService.getUserId(value);

        if (user_id == null)
            return Collections.emptyList();
        else
            return orderService.queryOrdersByUserId(user_id, status.toLowerCase());
    }


    @PostMapping("/order/refund/{order_id}")
    @ResponseBody
    public Order refundOrderByOrderId(@PathVariable Integer order_id) {
        return orderService.refundOrderByOrderId(order_id);
    }


    @PostMapping("/ticket/refund/{ticket_id}")
    @ResponseBody
    public Ticket refundTicketByTicketId(@PathVariable Integer ticket_id) {
        return ticketService.refundTicketByTicketId(ticket_id);
    }


    @PostMapping("/book")
    @ResponseBody
    public Integer bookTickets(@RequestBody OrderPost object) {
        Integer creator_id = userService.getUserId(object.getCreator());
        if (object.getTsis().size() == 1) {
            return orderService.bookTicketWithNewOrder(creator_id, object.getTsis().get(0));
        } else {
            Integer order_id = -1;
            for (int i = 0; i < object.getTsis().size(); i++) {
                if (order_id == -1)
                    order_id = orderService.bookTicketWithNewOrder(creator_id, object.getTsis().get(i));
                else {
                    Integer passenger_user_id = userService.getUserId(object.getRecipients().get(i));
                    orderService.bookTicketWithOrder(passenger_user_id, object.getTsis().get(i), order_id);
                }
            }
            return order_id;
        }
    }


    @PostMapping("/ticket/check")
    @ResponseBody
    public Integer checkTicketByTicketId(@RequestParam("ticket_id") Integer ticket_id) {
        ticketService.checkTicketByTicketId(ticket_id);
        return 1;
    }

    @PostMapping("/order/pay")
    @ResponseBody
    public String secureOrderByOrderId(@RequestParam("order_id") Integer order_id) {
        return orderService.secureOrderByOrderId(order_id).getStatus();
    }

}