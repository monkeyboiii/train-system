package train.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import train.model.Ticket;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TicketMapperTest {

    @Autowired
    TicketMapper ticketMapper;

    @Test
    public void myTicketMapperTest() {
        List<Ticket> tickets = ticketMapper.queryTicketByOrderId(23);

        for (Ticket t : tickets) {
            Ticket ticket = ticketMapper.refundTicketByTicketId(t.getTicket_id());
            System.out.println(ticket);
        }
    }

    @Test
    public void myTicketMapperCheckTest() {
        ticketMapper.checkTicketByTicketId(15);
    }
}