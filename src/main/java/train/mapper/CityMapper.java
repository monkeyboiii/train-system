package train.mapper;

import org.springframework.stereotype.Repository;
import train.model.City;

import java.util.List;


/**
 * Only select method, no modify
 */
@Repository
public interface CityMapper {

    City queryByCode(Integer city_code);

    City queryByName(String city_name);

    List<City> queryByProvince(String province_name);

}
