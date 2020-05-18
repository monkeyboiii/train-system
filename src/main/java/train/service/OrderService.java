package train.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.mapper.OrderMapper;
import train.model.Order;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public List<Order> queryOrdersByUserId(Integer user_id, String status) {
        List<Order> orders = orderMapper.queryOrdersByUserId(user_id, status);
        for (Order o : orders) o.translateStatus();
        return orders;
    }

    public Integer bookTicketWithNewOrder(Integer passenger_id, Integer ticket_set_id) {
        return orderMapper.bookTicketWithNewOrder(passenger_id, ticket_set_id);
    }

    public Integer bookTicketWithOrder(Integer passenger_id, Integer ticket_set_id, Integer order_id) {
        return orderMapper.bookTicketWithOrder(passenger_id, ticket_set_id, order_id);
    }

    public Order secureOrderByOrderId(Integer order_id) {
        return orderMapper.secureOrderByOrderId(order_id);
    }

    /**
     * Only non-finished-status orders can be refunded,
     * i.e. pending, ongoing
     */
    public Order refundOrderByOrderId(Integer order_id) {
        Order order = orderMapper.queryOrdersByOrderId(order_id);
        if (order.getStatus().equals("finished") || order.getStatus().equals("refunded")) {
            return Order.builder().order_id(-1).build();
        }
        return orderMapper.refundOrderByOrderId(order_id);
    }

}
