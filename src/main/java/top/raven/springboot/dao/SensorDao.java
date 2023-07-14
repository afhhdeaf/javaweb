package top.raven.springboot.dao;

import java.util.ArrayList;
import java.util.List;

public class SensorDao {
    private String name;
    private String dataStr;
    private List<Integer> data = new ArrayList<>();

    public void data2Array(){
        for(String item: dataStr.split(",")){
            data.add(Integer.parseInt(item));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }

    public List<Integer> getData() {
        data2Array();
        return data;
    }
}
