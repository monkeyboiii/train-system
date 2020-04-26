package train.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import train.model.Order;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void MyOrderTest() {
        List<Order> orders = orderMapper.queryOrdersByUserId(1);
        System.out.println(orders);
    }

}