package train.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private int user_id;
    private String username;
    private String id;
    private String phone;
    private String password;

    protected User() {
    }

    public User(String username, String id, String phone, String password) {
        super();
        this.username = username;
        this.id = id;
        this.phone = phone;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
