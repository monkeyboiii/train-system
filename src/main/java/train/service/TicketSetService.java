package train.service;

import train.mapper.TicketSetMapper;
import train.model.TicketSet;

import java.sql.Date;
import java.util.List;

public class TicketSetService {

    TicketSetMapper ticketSetMapper;

    public TicketSet queryRemainTicketByRouteID(Integer route_id) {
        return new TicketSet();
    }
}