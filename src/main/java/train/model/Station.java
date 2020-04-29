package train.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Station {
    private String station_name;
    private String city_name;

    @Singular
    List<String> trains; // Passing stations TODO: Add concrete trains


    @Builder
    public Station(String station_name, String city_name, List<String> trains) {
        this.station_name = station_name;
        this.city_name = city_name;
        this.trains = trains;
    }
}
