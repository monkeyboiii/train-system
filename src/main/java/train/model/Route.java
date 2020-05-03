package train.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Route {
    @ToString.Exclude
    protected Integer route_id;
    protected String train_code;


    protected String depart_station;
    protected Time depart_time;
    protected String depart_order; // 始/过

    protected String arrive_station;
    protected Time arrive_time;
    protected String arrive_order; // 过/终

    protected Integer arrive_day;


    TicketSet ticketSet; // Association

}
