package train.model;

import lombok.*;

import java.util.Date;
import java.util.List;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TicketSet {

    private String route_id;
    private Date date;
    private List<Price> prices;
    private List<Remain> remains;
//    private Map<String, Double> prices;
//    private Map<String, Integer> remains;

}
