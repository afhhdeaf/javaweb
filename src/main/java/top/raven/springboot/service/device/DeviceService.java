package top.raven.springboot.service.device;

import top.raven.springboot.dao.DeviceDao;

import java.util.List;

public interface DeviceService {
    List<DeviceDao> selectAll();
}
