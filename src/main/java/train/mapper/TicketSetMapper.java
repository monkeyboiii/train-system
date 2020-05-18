package train.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import train.model.TicketSet;

import java.util.List;

@Repository
public interface TicketSetMapper {

    TicketSet queryTicketSetByRouteIdAndDate(@Param("route_id") Integer route_id,
                                             @Param("date") String date);

    void generateTicketSetWithConditions(@Param("date") String date,
                                         @Param("stations1") List<String> stations1,
                                         @Param("stations2") List<String> stations2);

    Integer countPossibleRoute(@Param("date") String date,
                               @Param("stations1") List<String> stations1,
                               @Param("stations2") List<String> stations2);

    Boolean checkIfTicketSetIsThere(String date);

    void dropIndex();

    void createIndex();
}
