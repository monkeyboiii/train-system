package train.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import train.model.Order;
import train.model.Ticket;
import train.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {

    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    TicketMapper ticketMapper;


    @Test
    public void MyOrderTest() {
        List<Order> orders = orderMapper.queryOrdersByUserId(1, "pedning");
//        List<Order> orders = orderMapper.queryOrdersByUserId(1, "closed");
//        List<Order> orders = orderMapper.queryOrdersByUserId(2, "all");
        System.out.println(orders);

        Random random = new Random();
        Integer order_id = orderMapper.bookTicketWithNewOrder(
                1, random.nextInt(1748430));

        System.out.println("order_id = " + order_id);

        Integer order_id2 = orderMapper.bookTicketWithOrder(2, random.nextInt(1748430), order_id);

        System.out.println("order_id2 = " + order_id2);

    }


    @Test
    public void secureAndRefundTest() {
        String name = "东北大汉";
        int ticketsToHoard = 10;
        int peopleInTable = 3;


        User user = new User(name,
                "230102200408075418",
                "16789346893",
                "barbecue");
        userMapper.insertUser(user);
        Map<String, String> map = new HashMap<>();
        map.put("key", "username");
        map.put("value", name);
        Integer user_id = userMapper.getPrimaryKey(map);


        Random random = new Random();
        Integer order_id = orderMapper.bookTicketWithNewOrder(
                user_id, random.nextInt(1748430));
        for (int i = 1; i <= ticketsToHoard; i++) {
            orderMapper.bookTicketWithOrder(1 + random.nextInt(peopleInTable),
                    random.nextInt(1748430),
                    order_id);
        }


        Order order = orderMapper.queryOrdersByOrderId(order_id);
        System.out.println(order);
        orderMapper.secureOrderByOrderId(order_id);
        System.out.println(order);
        orderMapper.refundOrderByOrderId(order_id);
        System.out.println(order);
    }


    @Test
    public void check() {
        Integer order_id = 14;

        Order order = orderMapper.queryOrdersByOrderId(order_id);

        for (Ticket t : order.getTickets()) {
            System.out.println("t.getSeat_type() = " + t.getSeat_type());
            ticketMapper.checkTicketByTicketId(t.getTicket_id());
        }

    }


}