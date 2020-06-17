package com.jmwdm.framework.Tools;
import java.util.List;

import net.sf.json.JSONObject;
public class JsonFormat {
    /**
     * 格式化json返回串
     * @param code 200-成功 100-失败
     * @param msg
     * @return
     */
    public static JSONObject formatJsonBody(int code, String msg){
        JSONObject json = new JSONObject();
        json.put("code",code);
        JSONObject body = new JSONObject();
        body.put("msg",msg);
        json.put("body",body);
        return json;
    }

    /**
     *
     * @param code
     * @param msg
     * @param obj
     * @return
     */
    public static JSONObject formatJsonBody(int code, String msg,Object obj){
        JSONObject json = new JSONObject();
        json.put("code",code);
        JSONObject body = new JSONObject();
        body.put("msg",msg);
        body.put("info",obj);
        json.put("body",body);
        return json;
    }

    /**
     * 格式化json列表
     * @param code  200-成功 100-失败
     * @param msg 提示消息
     * @param obj List实例
     * @return
     */
    public static JSONObject formatJsonList(int code,String msg,Object obj){
        JSONObject json = new JSONObject();
        json.put("code",code);
        json.put("msg",msg);
        json.put("list",obj);
        return json;
    }
    
    /**
     * 
     * @param code
     * @param msg
     * @param total
     * @param obj
     * @return
     */
    public static JSONObject formatList(int code,String msg,long total, Object obj){
        JSONObject json = new JSONObject();
        json.put("code",code);
        json.put("msg",msg);
        json.put("list",obj);
        json.put("totalCount", total);
        return json;
    }
}
