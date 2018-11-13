package com.peter.bj.controller;

import com.peter.bj.util.NetworkUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller层，用于前后台交互(网站接入).
 * @author panxinbing
 *
 */
@Controller
@RequestMapping("/bj/back")
public class SwitchInWebsiteController {

    @RequestMapping(value = "/website")
    @ResponseBody
    public Map<String,String> insertCode(HttpServletRequest request, HttpServletResponse response)  {
        //获取当前的Ip
        String ip="";
        try {
             ip =NetworkUtil.getIpAddress(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,String> result = new HashMap();
        result.put("userId","userId");
        result.put("url",ip);
        return result;
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String insertCode(){
        String aa ="4444444444444";
        return aa;
    }

}
