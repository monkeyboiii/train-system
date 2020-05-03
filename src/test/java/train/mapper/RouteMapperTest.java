package train.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import train.model.Route;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RouteMapperTest {

    @Autowired
    RouteMapper routeMapper;

    @Test
    public void myRouteMapperTest() {
        List<Route> routes = routeMapper.queryRouteByStation(
                "杭州东",
                "北京南",
                "2020-05-21");

        System.out.println("routes.size() = " + routes.size());

        for (Route r : routes) {
            System.out.println(r);
        }

    }
}