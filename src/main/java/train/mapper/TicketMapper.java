package train.mapper;

import org.springframework.stereotype.Repository;
import train.model.Ticket;

import java.util.List;

@Repository
public interface TicketMapper {

    List<Ticket> queryTicketByOrderId(Integer order_id);

    Ticket refundTicketByTicketId(Integer ticket_id);

    void checkTicketByTicketId(Integer ticket_id);

    void checkTicketByTime();

}
