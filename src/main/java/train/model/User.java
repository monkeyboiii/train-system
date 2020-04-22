package train.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Builder
public class User {

    private String username;
    private String id; // Identity card
    private String phone;
    private String password;
    // TODO: Add order list

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        // Shouldn't generate users with same id or phone
        return id.equals(user.id) || phone.equals(user.phone);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, phone);
    }
}
