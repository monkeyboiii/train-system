package train.model;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Status: pending, ongoing, finished, closed
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private Integer order_id;
    private Timestamp create_time;
    private String status;
    private Integer user_id;
    private String creator_name;

    private Double price;

    @Singular
    private List<Ticket> tickets;


    public void translateStatus() {
        switch (this.status) {
            case "pending" -> this.status = "待付款";
            case "ongoing" -> this.status = "进行中";
            case "finished" -> this.status = "已完成";
            case "closed" -> this.status = "已退款";
            default -> this.status = "未知";
        }
    }

}
