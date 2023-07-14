package top.raven.springboot.service.sensor;

import top.raven.springboot.dao.SensorDao;

import java.util.List;

public interface SensorService {
    public List<SensorDao> selectAll();
}
