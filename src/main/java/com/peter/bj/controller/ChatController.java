package com.peter.bj.controller;

import com.peter.bj.service.IChatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author panxinbing
 *         create time:  2018/4/29.
 */
@Controller
@RequestMapping("/bj/chat")
public class ChatController {

    @Resource
    IChatService chatService;
    /**
     *  查询图灵问答接口
     * @param sentence 询问的语句.
     * @return
     */
    @RequestMapping(value="text")
    @ResponseBody
    public Map<String,String> getTuResult(@RequestParam(value = "param") String sentence){
        String answer=chatService.getAskResult(sentence);
        Map<String,String> result = new HashMap<>();
        result.put("answer",answer);
        result.put("status","success");
        return result;
    }
}
