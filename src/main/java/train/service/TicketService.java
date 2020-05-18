package train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.mapper.TicketMapper;
import train.model.Ticket;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketMapper ticketMapper;

    public List<Ticket> queryTicketByOrderId(Integer order_id) {
        return ticketMapper.queryTicketByOrderId(order_id);
    }

    public Ticket refundTicketByTicketId(Integer ticket_id) {
        return ticketMapper.refundTicketByTicketId(ticket_id);
    }

    public void checkTicketByTicketId(Integer ticket_id) {
        ticketMapper.checkTicketByTicketId(ticket_id);
    }

    public void checkTicketByTime() {
        ticketMapper.checkTicketByTime();
    }

}
