package train.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class City {
    private int cite_code;
    private String cite_name;
    private String province_name;
}