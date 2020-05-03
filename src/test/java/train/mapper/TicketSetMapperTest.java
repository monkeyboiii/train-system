package train.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import train.model.TicketSet;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketSetMapperTest {

    @Autowired
    TicketSetMapper ticketSetMapper;

    @Test
    public void myTicketSetMapperTest() {

        String a = Date.valueOf("2020-05-21").toString();
        System.out.println(a);

        TicketSet ticketSet = ticketSetMapper.queryTicketSetByRouteIdAndDate(1234, Date.valueOf("2020-05-21").toString());

//        TicketSet ticketSet = ticketSetMapper.queryTicketSetByRouteIdAndDate(1234);

        System.out.println(ticketSet);
        System.out.println("ticketSet.getPrices() = " + ticketSet.getPrices());
        System.out.println("ticketSet.getRemains()() = " + ticketSet.getRemains());

    }
}