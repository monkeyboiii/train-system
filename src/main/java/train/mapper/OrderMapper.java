package train.mapper;

import org.springframework.stereotype.Repository;
import train.model.Order;

import java.util.List;

@Repository
public interface OrderMapper {

    List<Order> queryOrdersByUserId(Integer user_id);

    int createOrderForUser(Integer user_id);

}
