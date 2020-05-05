package train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.mapper.CityMapper;
import train.model.City;

@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;


    public City queryCityByName(String value) {
        if (value.endsWith("市"))
            value = value.substring(0, value.length() - 1);
        return cityMapper.queryCityByName(value);
    }

}
