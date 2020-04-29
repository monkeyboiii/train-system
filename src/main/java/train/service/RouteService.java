package train.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.mapper.RouteMapper;
import train.model.Route;
import train.model.TransitRoute;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    RouteMapper routeMapper;


    public List<Route> queryRouteByStation(String depart, String arrive) {
        return routeMapper.queryRouteByStation(depart, arrive);
    }



    public List<TransitRoute> queryTransitRouteByStation(String depart, String arrive) {
        return routeMapper.queryTransitRouteByStation(depart, arrive);
    }


}
