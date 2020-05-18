package train.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import train.model.User;

import java.util.Map;

@Repository
public interface UserMapper {

    /**
     * Can trace user_id using username, id or phone.
     * Map contains the relations of the key-value pair,
     * e.g. {"key" = "phone", "value" = "135****4691"}
     */
    Integer getPrimaryKey(Map<String, String> map);

    void insertUser(User user);

    void updateUser(@Param("user_id") Integer user_id,
                    @Param("password") String password);

    User queryUserByUsername(String username);

    User queryUserById(String id);

    User queryUserByPhone(String phone);

    void deleteUser(Integer user_id);

    void postTokenByUsername(@Param("username") String username,
                             @Param("token") String token);

    Integer confirmTokenByUsername(@Param("username") String username,
                                   @Param("token") String token);

    Integer assignCreditByUserId(@Param("user_id") Integer user_id,
                                 @Param("credit") String credit);

    void cleanTokenByUsername(String username);

}
