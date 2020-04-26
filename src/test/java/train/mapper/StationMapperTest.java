package train.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import train.model.Station;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StationMapperTest {

    @Autowired
    StationMapper stationMapper;

    @Test
    public void myStationMapperTest() {
        List<Station> hz = stationMapper.queryStationByCityCode(330100);
        List<Station> gz = stationMapper.queryStationByCityCode(440100);
        System.out.println(hz);
        System.out.println(gz);
    }

}