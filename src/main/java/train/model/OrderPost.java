package train.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderPost implements Serializable {
    private String creator;

    private List<Integer> tsis;
    private List<String> recipients;

}
