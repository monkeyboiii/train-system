package train.model;


import org.junit.Test;


// POJO Test
public class UserTest {

    @Test
    public void UserGenerate() {
        User user = User.builder().
                username("Calvin").
                phone("13588454691").
                id("330103200004161619").
                password("password").
                build();
        System.out.println(user);
        System.out.println(user.hashCode());

        User user2 = User.builder().
                username("Nivlac").
                phone("85440965").
                id("33010320000416161X").
                password("wordpass").
                build();
        if (user.equals(user2)) {
            System.out.println("Equal, shouldn't allow");
        } else {
            System.out.println(user2);
        }

    }

    @Test
    public void UserHashTest() {
        User user = User.builder().
                username("Calvin").
                phone("13588454691").
                id("330103200004161619").
                password("password").build();
        System.out.println(user);
        System.out.println(user.hashCode());
    }

}

