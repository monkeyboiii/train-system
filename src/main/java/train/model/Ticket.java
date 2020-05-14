package train.model;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private Integer ticket_id;
    private Integer ticket_set_id; // TODO: specific route
    private String seat_type;
    private String seat_number;
    private Boolean refunded;
    //    private Boolean finished; // Internal
    private Date date;

    private String passenger_name;
}
