package top.raven.springboot.service.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.raven.springboot.dao.SensorDao;
import top.raven.springboot.mapper.SensorMapper;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorMapper sensorMapper;

    @Override
    public List<SensorDao> selectAll() {
        return sensorMapper.selectAll();
    }
}
