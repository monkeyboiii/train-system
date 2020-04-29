package train.model;

import lombok.*;

import java.util.List;

/**
 * A city has multiple stations
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class City {

    private String city_name;
    private List<Station> stations;

}