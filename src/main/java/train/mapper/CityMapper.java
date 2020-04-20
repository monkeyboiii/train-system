package train.mapper;

import org.springframework.stereotype.Repository;
import train.model.City;

import java.util.List;

@Repository
public interface CityMapper {

    City queryByCode(int city_code);

    List<City> queryAll();
}
