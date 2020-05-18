package train.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import train.model.Train;

@Repository
public interface TrainMapper {

    Train queryTrainByTrainCode(String train_code);

    String addStation(@Param("train_code") String train_code,
                      @Param("station_name")String station_name ,
                      @Param("time")String time,
                      @Param("arrive_day") Integer arrive_day);

    String deleteStation(@Param("train_code") String train_code,
                      @Param("station_name")String station_name);
}
