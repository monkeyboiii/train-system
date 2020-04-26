package train.mapper;

import org.springframework.stereotype.Repository;
import train.model.User;

import java.util.Map;

@Repository
public interface UserMapper {

    /**
     * Can trace user_id using username, id or phone.
     * Map contains the relations of the key-value pair,
     * e.g. {"key" = "username", "value" = "135****4691"}
     */
    Integer getPrimaryKey(Map<String, String> map);

    void insertUser(User user);

    void updateUser(Integer user_id, String password);

    User queryUserByUsername(String username);

    User queryUserById(String id);

    User queryUserByPhone(String phone);

    void deleteUser(Integer user_id);

}
