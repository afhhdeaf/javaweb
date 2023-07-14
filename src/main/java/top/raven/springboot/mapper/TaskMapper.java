package top.raven.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.raven.springboot.dao.TaskProgressDao;

import java.util.List;

@Mapper
@Repository
public interface TaskMapper {
    List<TaskProgressDao> selectAll();
}
