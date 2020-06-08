package train.mapper;

import org.springframework.stereotype.Repository;
import train.model.City;

import java.util.List;

@Repository
public interface CityMapper {

    // Only select method, no modify

    City queryByCode(int city_code);

    City queryByName(String city_name);

    List<City> queryByProvince(String province_name);

    List<City> queryAll(int limit);

}
