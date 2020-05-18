package train.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface StationMapper {

    String confirmStationsByStationName(String station_name);
}
