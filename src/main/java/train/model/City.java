package train.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class City {
    private int city_code;
    private String city_name;
    private String province_name;
    // TODO: Add station/train list

}