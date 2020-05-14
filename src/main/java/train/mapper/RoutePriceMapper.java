package train.mapper;

public interface RoutePriceMapper {

    Integer updateRoutePrice(Integer train_code,
                             String depart,
                             String arrive,
                             String seat_type,
                             Double price);

}
