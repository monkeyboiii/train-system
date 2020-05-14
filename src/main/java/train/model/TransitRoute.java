package train.model;

import lombok.*;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransitRoute extends Route {

    @ToString.Exclude
    protected Integer transit_route_id;
    protected String transit_train_code;


    protected String transit_depart_station; // same as arrive_station in route object
    protected String transit_depart_order;
    protected Time transit_depart_time;

    protected String transit_arrive_station;
    protected String transit_arrive_order;
    protected Time transit_arrive_time;

    protected Integer transit_arrive_day;


    protected TicketSet transit_ticketSet;

}
