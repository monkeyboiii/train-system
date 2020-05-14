package train.model;


import lombok.*;

import java.util.List;
import java.util.Objects;

/**
 * A user has an internal user_id inside database.
 * A user can purchase multiple orders, and each order can secure multiple tickets.
 * Store order_ids in an integer list.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String username;
    private String id; // Identity card
    private String phone;
    private String password;
    private String credit;

    private List<Integer> orders;


    /**
     * Use when inserting
     */
    public User(String username, String id, String phone, String password, String credit) {
        this.username = username;
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.credit = credit.substring(0, 1).toLowerCase();
    }

    public User(String username, String id, String phone, String password) {
        this.username = username;
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.credit = "u";
    }


    /**
     * No private information shown
     */
    @Override
    public String toString() {
        return "User{" +
                "username= '" + username + '\'' +
                ", phone= '" + phone.substring(0, 3) + "*****" + phone.substring(phone.length() - 3) + '\'' +
                ",total orders= " + (orders == null ? "0" : orders.size()) +
                '}';
    }


    /**
     * Shouldn't generate users with same id or phone
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) || phone.equals(user.phone);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, phone);
    }
}