package top.raven.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.raven.springboot.dao.DeviceDao;

import java.util.List;

@Mapper
@Repository
public interface DeviceMapper {
    List<DeviceDao> selectAll();
}
