package train;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan({"train.mapper"})
@EnableTransactionManagement
public class TrainApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TrainApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

}
