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
public class Order {
    private Integer order_id;
    private Timestamp create_time;
    private String status;
    private Integer user_id;
    private String creator_name;

    @Singular
    private List<Ticket> tickets;


    private void translateStatus() {
        switch (this.status) {
            case "pending":
                this.status = "待付款";
                break;
            case "ongoing":
                this.status = "进行中";
                break;
            case "finished":
                this.status = "已完成";
                break;
            case "closed":
                this.status = "已退款";
                break;
            default:
                this.status = "未知";
        }
    }

}
