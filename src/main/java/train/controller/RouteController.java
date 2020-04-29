package train.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import train.model.City;
import train.model.Station;
import train.model.Route;
import train.service.CityService;
import train.service.RouteService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
public class RouteController {

    @Autowired
    CityService cityService;
    @Autowired
    RouteService routeService;


    @GetMapping("/route/city")
    public List<Route> queryRouteByCity(@RequestParam("depart") String depart,
                                        @RequestParam("arrive") String arrive) {
        City departure = cityService.queryCityByName(depart);
        City arrival = cityService.queryCityByName(arrive);
        if (departure == null || arrival == null)
            return Collections.emptyList();

        List<Route> ans = new ArrayList<>();
        for (Station dep : departure.getStations()) {
            for (Station arr : arrival.getStations()) {
                List<Route> routes = routeService.
                        queryRouteByStation(dep.getStation_name(),
                                arr.getStation_name());
                if (!routes.isEmpty()) {
                    ans.addAll(routes);
                }
            }
        }
        return ans;
    }


    @GetMapping("/route/station")
    public List<?> queryRouteByStation(@RequestParam("depart") String depart,
                                       @RequestParam("arrive") String arrive,
                                       @RequestParam("transit") Boolean transit) {
        if (!transit)
            return routeService.queryRouteByStation(depart, arrive);
         else
            return routeService.queryTransitRouteByStation(depart, arrive);
    }
}
