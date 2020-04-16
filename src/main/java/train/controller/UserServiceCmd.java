package train.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import train.model.User;
import train.service.UserService;

import java.util.Scanner;


@Component
public class UserServiceCmd implements CommandLineRunner {
    private static final Logger log =
            LoggerFactory.getLogger(UserServiceCmd.class);

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter: ");
        int op = scanner.nextInt();
        while (op != 0) {
            User user = new User("Calvin",
                    "330103200004161619",
                    "13588454691",
                    "password");
            int id = userService.insert(user);
            log.info("New user: " + user);
            op--;
        }


    }
}
