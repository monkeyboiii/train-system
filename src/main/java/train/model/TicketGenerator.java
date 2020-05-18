package train.model;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class TicketGenerator {
    private String username;
    private String token;
    private String date;
    @Singular
    private List<String> stations;
}
