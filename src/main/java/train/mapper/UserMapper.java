package train.mapper;

import org.springframework.stereotype.Repository;
import train.model.User;

import java.util.Map;

@Repository
public interface UserMapper {

    // Can trace user_id using username, id or phone
    int getPrimaryKey(Map<String, String> map);

    void insertUser(User user);

    void updateUser(int user_id, String password);

    User queryUserByUsername(String username);

    User queryUserById(String id);

    User queryUserByPhone(String phone);

    void deleteUser(int user_id);

}
