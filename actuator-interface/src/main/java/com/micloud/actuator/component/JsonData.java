package com.micloud.actuator.component;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/11/06 14:39
 */
@Getter
@Setter
public class JsonData   implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean ret;

    private String msg;

    private Object data;

    private int code;
    /** 列表获取时是否有下一页 **/
    private boolean  hasNext;
    /** 数量 **/
    private long count;


    public JsonData() {
    }

    public JsonData(boolean ret) {
        this.ret = ret;
        if(ret){
            this.code = 0;
        }else{
            this.code = 1;
        }
    }

    public static JsonData success(Object object, String msg) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData successCode(int code, Object object, String msg) {
        JsonData jsonData = new JsonData(true);
        jsonData.code = code;
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData fail(Object object, String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData success(Object object) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        return jsonData;
    }



    public static JsonData success() {
        return new JsonData(true);
    }

    public static JsonData fail(String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData failCode(int code,String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.code = code;
        jsonData.msg = msg;
        return jsonData;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("ret", ret);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    public boolean isRet() {
        return ret;
    }
}
