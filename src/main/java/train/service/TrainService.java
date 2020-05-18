package train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.mapper.TrainMapper;
import train.model.Train;

@Service
public class TrainService {

    @Autowired
    TrainMapper trainMapper;


    public Train queryTrainByTrainCode(String train_code) {
        return trainMapper.queryTrainByTrainCode(train_code);
    }

    public String addStation(String train_code, String station_name, String time, Integer arrive_day) {
        return trainMapper.addStation(train_code, station_name, time, arrive_day);
    }

    public String deleteStation(String train_code, String station_name) {
        return trainMapper.deleteStation(train_code, station_name);
    }

}