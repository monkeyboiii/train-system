package train.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import train.model.Train;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrainMapperTest {

    @Autowired
    TrainMapper trainMapper;

    @Test
    public void TestOne() {
        Train train = trainMapper.queryTrainByTrainCode("G32");
        System.out.println(train);
    }
}