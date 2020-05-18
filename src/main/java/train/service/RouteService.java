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


    public List<Route> queryRouteByStation(String depart, String arrive, String date) {
        return routeMapper.queryRouteByStation(depart, arrive, date);
    }

    public List<Route> queryRouteByCity(String depart, String arrive, String date) {
        return routeMapper.queryRouteByCity(depart, arrive, date);
    }


    public List<TransitRoute> queryTransitRouteByStation(String depart, String arrive,String date) {
        return routeMapper.queryTransitRouteByStation(depart, arrive,date);
    }


}
