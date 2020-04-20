package train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import train.service.CityService;

@RestController
@RequestMapping("/api/v1")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city/{city_code}")
    public String show(@PathVariable int city_code) {
        return cityService.queryByCode(city_code).toString();
    }

}
