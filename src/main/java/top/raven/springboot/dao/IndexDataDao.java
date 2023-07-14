package top.raven.springboot.dao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IndexDataDao {
    private String[] axis = new String[]{"Mon", "Tues", "Wed", "Thur", "Fri", "Sat", "Sun"};
    private List<DeviceDao> device;
    private List<TaskProgressDao> taskProgress;

    private List<SensorDao> sensors;

    public List<SensorDao> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorDao> sensors) {
        this.sensors = sensors;
    }

    public List<DeviceDao> getDevice() {
        return device;
    }

    public void setDevice(List<DeviceDao> device) {
        this.device = device;
    }

    public List<TaskProgressDao> getTaskProgress() {
        return taskProgress;
    }

    public void setTaskProgress(List<TaskProgressDao> taskProgress) {
        this.taskProgress = taskProgress;
    }

    public String[] getAxis() {
        return axis;
    }
}
