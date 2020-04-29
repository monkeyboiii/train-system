package train.mapper;

import java.util.List;

public interface TicketSetMapper {

    List<Integer> queryRemainTicketByRouteID(Integer route_id);

}
