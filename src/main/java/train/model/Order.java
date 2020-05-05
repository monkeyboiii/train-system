package train.model;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Status: pending, ongoing, finished, closed
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer order_id;
    private Timestamp create_time;
    private String status;
    private Integer user_id;
    private String creator_name;

    @Singular
    private List<Ticket> tickets;

}
