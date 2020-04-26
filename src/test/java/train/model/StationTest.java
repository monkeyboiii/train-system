package train.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StationTest {

    @Test
    public void StationModelTest(){
        Station station= Station.builder().build();
        System.out.println(station);

        System.out.println(Station.builder().toString());

        List<String> trains=new ArrayList<>();
        trains.add("G234");
        trains.add("G232");
        trains.add("G231");

        Station station1= Station.builder().station_name("hangzhou").trains(trains).build();

        System.out.println(station1);


    }
}