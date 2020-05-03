package train.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import train.model.Route;
import train.model.TransitRoute;

import java.util.List;

@Repository
public interface RouteMapper {

    List<Route> queryRouteByStation(@Param("depart") String depart,
                                    @Param("arrive") String arrive,
                                    @Param("date") String date);

    // TODO
    List<TransitRoute> queryTransitRouteByStation(@Param("depart") String depart,
                                                  @Param("arrive") String arrive,
                                                  @Param("date") String date
    );

}
