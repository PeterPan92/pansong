package com.peter.bj.service.impl;

import com.peter.bj.service.IChatService;
import com.peter.bj.util.HttpRequestUtils;
import com.peter.bj.util.ReadConfig;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author panxinbing
 *         create time:  2018/4/27.
 */
@Service("chatService")
public class ChatServiceImpl implements IChatService{

    /**
     *  调用图灵的问答接口，返回结果信息.
     * @param question 询问的问题
     * @return 返回问答结果
     */
    public String getAskResult(String question) {
        ReadConfig readConfig = new ReadConfig();
        String url = readConfig.getConfig("url","config/chat");
        String apikey = readConfig.getConfig("apikey","config/chat");
        String tuLingReturn =getTuLingAskResult(question,url,apikey);
        return tuLingReturn;
    }

    /**
     *  封装图灵的问答接口输入参数、查询内容，返回结果信息.
     * @param question 询问的问题
     * @param url 访问的url路径
     * @param apikey 访问秘钥
     * @return
     */
    private String getTuLingAskResult(String question, String url, String apikey){
        JSONObject paramJson = new JSONObject();
        //设置请求类型 0为文本类型
        paramJson.put("reqType","0");

        //设置请求参数,设置文本类型的参数
        JSONObject questionJson = new JSONObject();
        questionJson.put("text",question);
        JSONObject inputTextJson = new JSONObject();
        inputTextJson.put("inputText",questionJson);
        paramJson.put("perception",inputTextJson);

        //设置用户信息
        JSONObject userJson = new JSONObject();
        userJson.put("apiKey",apikey);
        userJson.put("userId","dialog");
        paramJson.put("userInfo",userJson);

        //查询图灵结果
        JSONObject tuLingReturnJson = HttpRequestUtils.httpPost(url,paramJson);

        //对图灵结果进行处理
        JSONArray results = tuLingReturnJson.getJSONArray("results");
        String answer = "我还小，请多多指教。";
        if(null!=results&&results.size()>0){
            Optional result =results.stream()
                    .filter(aa->(((JSONObject) aa).getString("resultType").equals("text")))
                    .findFirst();
            if(result.isPresent()){
                JSONObject textJson =JSONObject.fromObject(result.get());
                JSONObject valuesJSON = textJson.getJSONObject("values");
                answer = valuesJSON.getString("text");
            }
        }
        return answer;
    }
}
