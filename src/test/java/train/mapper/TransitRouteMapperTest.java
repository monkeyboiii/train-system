package train.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import train.model.TransitRoute;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TransitRouteMapperTest {

    @Autowired
    RouteMapper routeMapper;

    @Test
    public void myTransitRouteMapperTest() {

        List<TransitRoute> transitRoutes = routeMapper.
                queryTransitRouteByStation("玉林", "吐鲁番", "2020-05-21");

        System.out.println("transitRoutes.size() = " + transitRoutes.size());

        for (TransitRoute t : transitRoutes) {
            System.out.println("t.getTransit_ticketSet() = " + t.getTransit_ticketSet());
        }

    }


}