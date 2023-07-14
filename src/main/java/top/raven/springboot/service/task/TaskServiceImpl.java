package top.raven.springboot.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import top.raven.springboot.dao.TaskProgressDao;
import top.raven.springboot.mapper.TaskMapper;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<TaskProgressDao> selectAll() {
        return taskMapper.selectAll();
    }
}
