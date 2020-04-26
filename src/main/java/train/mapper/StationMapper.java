package train.mapper;

import org.springframework.stereotype.Repository;
import train.model.Station;

import java.util.List;

@Repository
public interface StationMapper {

    List<Station> queryStationByCityCode(Integer city_code);

}