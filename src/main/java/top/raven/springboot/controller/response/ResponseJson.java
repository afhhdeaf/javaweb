package top.raven.springboot.controller.response;

import com.alibaba.fastjson.JSONObject;

public class ResponseJson {
    public static JSONObject get(Object object){
        return (JSONObject) JSONObject.toJSON(object);
    }

}
