package train.mapper;

import org.springframework.stereotype.Repository;
import train.model.City;


/**
 * Only select method, no modify
 */
@Repository
public interface CityMapper {

    City queryCityByName(String city_name);

}
