package train.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Price {
    private String seat_type;
    private Double price;
}
