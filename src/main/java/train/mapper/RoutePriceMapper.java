package train.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutePriceMapper {

    Integer updateRoutePrice(@Param("train_code") String train_code,
                             @Param("depart") String depart,
                             @Param("arrive") String arrive,
                             @Param("seat_type") String seat_type,
                             @Param("price") Double price);

}
