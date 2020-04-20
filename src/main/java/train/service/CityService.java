package train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.mapper.CityMapper;
import train.model.City;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    public City queryByCode(int city_code) {
        return cityMapper.queryByCode(city_code);
    }

    public List<City> queryAll(){
        return cityMapper.queryAll();
    }
}
