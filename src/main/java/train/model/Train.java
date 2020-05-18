package train.model;


import lombok.*;

import java.sql.Time;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Train {

    private String train_code;
    private List<Station> stations;
    private List<Time> arrive_times;
    private List<Time> depart_times;

}



