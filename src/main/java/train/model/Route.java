package train.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;

@Getter
@Setter
@ToString
public class Route {
    @ToString.Exclude
    protected Integer route_id;

    protected String train_code;
    protected String depart_station;
    protected String arrive_station;
    private Time depart_time;
    private Time arrive_time;
    private Integer arrive_day;

}
