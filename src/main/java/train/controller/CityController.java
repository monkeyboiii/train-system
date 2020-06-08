package train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import train.model.City;
import train.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city/{value}") // Supports code and name
    public City queryCity(@PathVariable String value) {
        return cityService.queryCity(value);
    }

    @GetMapping("/cities/{value}") // Cities in province
    public List<City> queryByProvince(@PathVariable String value) {
        return cityService.queryByProvince(value);
    }

}
