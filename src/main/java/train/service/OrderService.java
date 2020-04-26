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

    public List<Order> queryOrdersByUserId(Integer user_id) {
        return orderMapper.queryOrdersByUserId(user_id);
    }

    public int createOrderForUserId(Integer user_id) {
        return orderMapper.createOrderForUser(user_id);
    }
}
