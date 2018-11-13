package com.peter.bj.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panxinbing
 *         create time:  2018/4/26.
 */
public class test {
    public static void main(String[] args) throws Exception {

    }

    /**
     * 测试http请求
     */
    public void test1(){
        String url ="http://10.9.11.107:8080/dialog-service/service/qa/ec/test3";
        Map<String,String> input = new HashMap<String,String>();
        String param = "company=111111";
        String result = HttpRequestUtils.getPostMap2(url,param);
        System.out.println(result);
    }

}
