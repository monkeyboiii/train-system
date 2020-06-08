package train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.mapper.CityMapper;
import train.model.City;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service // Should handle all the business logic
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    // Return single city
    public City queryCity(String value) {
        Matcher mer = Pattern.compile("^[+-]?[0-9]+$").matcher(value);
        if (mer.find())
            return cityMapper.queryByCode(Integer.parseInt(value));
        else
            return cityMapper.queryByName(value);
    }

    // Return cities in a province
    public List<City> queryByProvince(String province_name) {
        return cityMapper.queryByProvince(province_name);
    }

    // Abandoned
    public List<City> queryAll(int limit) {
        return cityMapper.queryAll(limit);
    }
}
