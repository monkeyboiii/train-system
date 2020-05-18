package train.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import train.model.City;
import train.model.Route;
import train.service.CityService;
import train.service.RouteService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Bundled route page
 */
@Controller
public class RouteController {

    @Autowired
    CityService cityService;
    @Autowired
    RouteService routeService;


    @GetMapping("/route")
    public String routePage() {
        return "user/route";
    }


    @PostMapping("/route/city")
    @ResponseBody
    public Object queryRouteByCity(@RequestParam("depart") String depart,
                                   @RequestParam("arrive") String arrive,
                                   @RequestParam("date") String date) {
        City departCity = cityService.queryCityByName(depart.trim());
        City arriveCity = cityService.queryCityByName(arrive.trim());
        if (departCity == null || arriveCity == null) {
            return Collections.emptyList();
        }

        Map<String, List> map = new HashMap<>();
        map.put("Route", routeService.queryRouteByCity(
                departCity.getCity_name(),
                arriveCity.getCity_name(),
                date));
        return map;
    }


    @PostMapping("/route/station")
    @ResponseBody
    public Object queryRouteByStation(@RequestParam("depart") String depart,
                                      @RequestParam("arrive") String arrive,
                                      @RequestParam("date") String date,
                                      @RequestParam(value = "transit", defaultValue = "false") Boolean transit) {
        Map<String, List> map = new HashMap<>();
        map.put("Route", Collections.emptyList());
        map.put("TransitRoute", Collections.emptyList());

        List<Route> routes = routeService.queryRouteByStation(depart.trim(), arrive.trim(), date);
        if (!transit) {
            if (!routes.isEmpty()) map.replace("Route", routes);
            else
                map.replace("TransitRoute", routeService.queryTransitRouteByStation(depart.trim(), arrive.trim(), date));
        } else {
            map.replace("Route", routes);
            map.replace("TransitRoute", routeService.queryTransitRouteByStation(depart.trim(), arrive.trim(), date));
        }
        return map;
    }


    @GetMapping("/city/{value}")
    @ResponseBody
    public City queryCityByName(@PathVariable String value) {
        City city = cityService.queryCityByName(value.trim());
        if (city == null)
            return new City();
        else
            return city;
    }

}
