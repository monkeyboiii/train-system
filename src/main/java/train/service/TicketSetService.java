package train.service;

import train.mapper.TicketSetMapper;

import java.util.List;

public class TicketSetService {

    TicketSetMapper ticketSetMapper;

    public List<Integer> queryRemainTicketByRouteID(Integer route_id) {
        return ticketSetMapper.queryRemainTicketByRouteID(route_id);
    }
}