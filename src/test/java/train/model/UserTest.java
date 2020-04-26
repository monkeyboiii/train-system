package train.model;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


// POJO Test
public class UserTest {

    @Test
    public void UserGenerate() {
        User user = new User(
                "Calvin",
                "13588454691",
                "330103200004161619",
                "password");

        System.out.println(user);
        System.out.println(user.hashCode());

        User user2 = new User(
                "Nivlac",
                "13588454391",
                "33010319994161619",
                "wordpress");
        if (user.equals(user2)) {
            System.out.println("Equal, shouldn't allow");
        } else {
            System.out.println(user2);
        }

    }

    @Test
    public void UserHashTest() {
        User user = new User(
                "Calvin",
                "330103200004161619",
                "13588454691",
                "password");

        List<Integer> orders = new ArrayList<>();
        orders.add(24);
        orders.add(22);
        orders.add(21);
        User user1 = new User("AS", "234", "17488547391", "pass",orders);

        System.out.println(user);
        System.out.println(user1);


    }

}

