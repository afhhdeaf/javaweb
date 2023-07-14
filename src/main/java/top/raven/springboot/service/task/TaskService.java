package top.raven.springboot.service.task;

import top.raven.springboot.dao.TaskProgressDao;

import java.util.List;

public interface TaskService {
    List<TaskProgressDao> selectAll();
}
