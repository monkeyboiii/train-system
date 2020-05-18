package train.model;

import lombok.*;

import java.sql.Time;
import java.util.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    private Integer ticket_id;

    private Integer ticket_set_id; // TODO: specific route

    private String train_code;
    private String depart_station;
    private Time depart_time;
    private String arrive_station;
    private Time arrive_time;
    private Date date;
    private Integer arrive_day;


    private String seat_type;
    private String seat_number;
    private Double price;

    private Boolean refunded;
    private Boolean finished;


    private String passenger_name;
}
