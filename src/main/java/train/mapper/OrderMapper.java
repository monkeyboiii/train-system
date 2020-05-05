package train.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import train.model.Order;

import java.util.List;

@Repository
public interface OrderMapper {

    List<Order> queryOrdersByUserId(@Param("user_id") Integer user_id,
                                    @Param("status") String status);

    Order queryOrdersByOrderId(@Param("order_id") Integer order_id);

    Integer bookTicketWithNewOrder(@Param("passenger_id") Integer passenger_id,
                                   @Param("ticket_set_id") Integer ticket_set_id);

    Integer bookTicketWithOrder(@Param("passenger_id") Integer passenger_id,
                                @Param("ticket_set_id") Integer ticket_set_id,
                                @Param("order_id") Integer order_id);

    Order secureOrderByOrderId(Integer order_id);

    Order refundOrderByOrderId(Integer order_id);

}
