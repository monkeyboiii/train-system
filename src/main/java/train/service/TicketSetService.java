package train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.mapper.StationMapper;
import train.mapper.TicketSetMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketSetService {

    @Autowired
    TicketSetMapper ticketSetMapper;
    @Autowired
    StationMapper stationMapper;


    public String generateTicketSetWithConditions(String date, List<String> stations) {

        if (ticketSetMapper.checkIfTicketSetIsThere(date)) {
            return "该日的票已经建过数据库！";
        }

        List<String> copy = new ArrayList<>(stations);

        ticketSetMapper.dropIndex();
        ticketSetMapper.generateTicketSetWithConditions(date, stations, copy);
        ticketSetMapper.createIndex();
        return "OK";
    }

}
