package top.raven.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.raven.springboot.dao.SensorDao;

import java.util.List;

@Mapper
@Repository
public interface SensorMapper {
    List<SensorDao> selectAll();
}
