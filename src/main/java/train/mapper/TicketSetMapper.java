package train.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import train.model.TicketSet;

@Repository
public interface TicketSetMapper {

    TicketSet queryTicketSetByRouteIdAndDate(@Param("route_id") Integer route_id,
                                             @Param("date") String date);

}
