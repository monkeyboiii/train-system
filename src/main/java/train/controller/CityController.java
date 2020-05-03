package train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import train.model.City;
import train.service.CityService;

/**
 * Returns city with its stations
 */
@RestController
@RequestMapping
public class CityController {

    @Autowired
    private CityService cityService;


    @GetMapping("/city/{value}")
    public City queryCityByName(@PathVariable String value) {
        return cityService.queryCityByName(value);
    }

}
