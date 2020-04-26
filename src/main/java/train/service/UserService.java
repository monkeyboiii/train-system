package train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.mapper.UserMapper;
import train.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Integer getUserId(String value) {
        Map<String, String> map = new HashMap<>(); // Value is a matcher
        if (isPhone(value)) {
            map.put("key", "phone");
            map.put("value", value);
        } else if (isId(value)) {
            map.put("key", "id");
            map.put("value", value);
        } else {
            map.put("key", "username");
            map.put("value", value);
        }
        return userMapper.getPrimaryKey(map); // May be null
    }

    public int insertUser(User user) {
        if (!isPhone(user.getPhone()) || !isId(user.getId())) {
            return 0;
        } else if (user.equals(queryUser(user.getPhone())) || user.equals(queryUser(user.getId()))) {
            return 0;
        } else {
            userMapper.insertUser(user);
            return 1;
        }
    }

    public int updateUser(String value, String password) {
        Integer user_id = getUserId(value);
        if (user_id == null)
            return 0;
        userMapper.updateUser(user_id, password);
        return 1;
    }

    public User queryUser(String value) {
        if (isPhone(value)) {
            return userMapper.queryUserByPhone(value);
        } else if (isId(value))
            return userMapper.queryUserById(value);
        else {
            return userMapper.queryUserByUsername(value);
        }
    }

    public int deleteUser(String value) {
        Integer user_id = getUserId(value);
        if (user_id == null)
            return 0;
        userMapper.deleteUser(user_id);
        return 1;
    }

    private static boolean isPhone(String str) {
        Pattern p;
        Matcher m;
        boolean isMatch;

        String regex = "^((13[0-9])|(14[579])|(15([0-3,5-9]))|(16[6])|(17[0135678])|(18[0-9]|19[89]))\\d{8}$";

        p = Pattern.compile(regex);
        m = p.matcher(str);
        isMatch = m.matches();
        return isMatch;
    }

    private static boolean isId(String str) {
        Pattern p;
        Matcher m;
        boolean isMatch;

        String regex = "^[1-9]\\d{5}[1-9]\\d{3}((0[1-9])|(1[0-2]))(0[1-9]|([1|2][0-9])|3[0-1])((\\d{4})|\\d{3}X)$";

        p = Pattern.compile(regex);
        m = p.matcher(str);
        isMatch = m.matches();
        return isMatch;
    }

}