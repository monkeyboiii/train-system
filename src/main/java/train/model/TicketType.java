package train.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketType {
    private Integer ticket_set_id;
    private String seat_type;
    private Double price;
    private Integer remain;

}
