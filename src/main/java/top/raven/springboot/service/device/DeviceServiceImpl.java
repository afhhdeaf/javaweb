package top.raven.springboot.service.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.raven.springboot.dao.DeviceDao;
import top.raven.springboot.mapper.DeviceMapper;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public List<DeviceDao> selectAll() {
        return deviceMapper.selectAll();
    }
}
