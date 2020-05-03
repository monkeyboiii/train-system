package train.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransitRoute extends Route {

    protected String transit_train_code;
    protected String transit_station;
    protected Time transit_time;

    @Override
    public String toString() {
        return "TransitRoute{" +
                ", train_code='" + train_code + '\'' +
                "transit_train_code='" + transit_train_code + '\'' +

                ", depart_station='" + depart_station + '\'' +
                ", transit_station='" + transit_station + '\'' +
                ", arrive_station='" + arrive_station + '\'' +

                ", depart_time=" + depart_time +
                ", transit_time=" + transit_time +
                ", arrive_time=" + arrive_time +

                ", arrive_day=" + arrive_day +
                '}';
    }
}
