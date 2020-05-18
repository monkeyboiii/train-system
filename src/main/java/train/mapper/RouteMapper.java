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

    List<Route> queryRouteByCity(@Param("depart") String depart,
                                 @Param("arrive") String arrive,
                                 @Param("date") String date);

    List<TransitRoute> queryTransitRouteByStation(@Param("depart") String depart,
                                                  @Param("arrive") String arrive,
                                                  @Param("date") String date);

    /*List<Route> addStationByAdmin(@Param("train_code") String train_code,
                                  @Param("station") String station,
                                  @Param("arrive_time") String arrive_time,
                                  @Param("depart_time") String depart_time,
                                  @Param("arrive_day") String arrive_day);

    String deleteStationByAdmin(@Param("train_code") String train_code,
                                @Param("station") String station);*/
}
