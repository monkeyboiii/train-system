package train.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import train.model.TicketSet;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketSetMapperTest {

    @Autowired
    TicketSetMapper ticketSetMapper;

    @Test
    public void myTicketSetMapperTest() {

        String a = Date.valueOf("2020-05-21").toString();
        System.out.println(a);

        TicketSet ticketSet = ticketSetMapper.queryTicketSetByRouteIdAndDate(1234, a);

        System.out.println(ticketSet);
        System.out.println("ticketSet.getPrices() = " + ticketSet.getTicketTypes());

    }

    @Test
    public void ttt() {
        ticketSetMapper.dropIndex();
        List<String> stations = new ArrayList<>();
        stations.add("深圳北");
        stations.add("杭州东");
        stations.add("北京南");
        stations.add("上海虹桥");
        List<String> copy = new ArrayList<>(stations);
        ticketSetMapper.generateTicketSetWithConditions("2020-05-29", stations, copy);
        ticketSetMapper.createIndex();
    }

    @Test
    public void att() {
        List<String> stations = new ArrayList<>();
        stations.add("深圳北");
        stations.add("杭州东");
        stations.add("北京南");
        stations.add("上海虹桥");
        List<String> strings = new ArrayList<>(stations);
        System.out.println(ticketSetMapper.countPossibleRoute("2020-05-29", stations, strings));
    }

}