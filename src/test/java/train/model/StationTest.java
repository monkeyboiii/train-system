package train.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StationTest {

    @Test
    public void StationModelTest(){
        Station station=new Station();
        System.out.println(station);


        List<String> trains=new ArrayList<>();
        trains.add("G234");
        trains.add("G232");
        trains.add("G231");


        System.out.println(station);


    }
}