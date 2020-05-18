package train.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AjaxResponse {
    private String status;
    private String msg;
    private String username;
    private String token;

    @Singular
    private List<Object> objects;
}
