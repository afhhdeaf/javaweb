package top.raven.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.raven.springboot.controller.response.Response;
import top.raven.springboot.controller.response.ResponseCode;
import top.raven.springboot.dao.IndexDataDao;
import top.raven.springboot.service.device.DeviceService;
import top.raven.springboot.service.sensor.SensorService;
import top.raven.springboot.service.task.TaskService;


@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private SensorService sensorService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private IndexDataDao indexData;

    @ResponseBody
    @GetMapping("/index")
    public Response index(){
        indexData.setDevice(deviceService.selectAll());
        indexData.setTaskProgress(taskService.selectAll());
        indexData.setSensors(sensorService.selectAll());

        boolean flag = indexData.getDevice() == null || indexData.getSensors() == null;
        return new Response(flag ? ResponseCode.GET_OK: ResponseCode.GET_ERR, indexData);
    }
}
