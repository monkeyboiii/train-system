package train.model;

import java.util.Date;
import java.util.Map;

public class TicketSet {
    private String ticket_set_id;
    private String route_id;
    private Date date;
    private Map<String, Double> price; // According to seat_type
    private Map<String, Integer> remain;
}
