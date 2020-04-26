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
    @ToString.Exclude
    private Integer city_code;

    private String city_name;
    private String province_name;

    private List<Station> stations; // Names

}