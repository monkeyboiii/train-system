package train.mapper;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import train.mapper.UserMapper;
import train.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void postUserTest() {
        User user = new User(
                "Monkey",
                "31010320050226161X",
                "13767839784",
                "6969");
        System.out.println(user);
        userMapper.insertUser(user);

        User myUser = userMapper.queryUserByUsername("Monkey");
        System.out.println(myUser);

        // Here we know the
        userMapper.updateUser(2,"pussycat");

    }
}


