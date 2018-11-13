package com.peter.bj.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @title Rest访问工具
 * @author 框架产品组
 *
 */
public class HttpRequestUtils {
    
    private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class); // 日志记录

    /**
     * httpPost
     * 
     * @param url [路径]
     * @param jsonParam [参数]
     * @return
     */
    public static JSONObject httpPost(String url, JSONObject jsonParam) {
        return httpPost(url, jsonParam, false);
    }

    /**
     * post请求
     * 
     * @param url [url地址]
     * @param jsonParam [参数]
     * @param noNeedResponse [不需要返回结果]
     * @return
     */
    public static JSONObject httpPost(String url, JSONObject jsonParam, boolean noNeedResponse) {
        // post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
//            url = URLDecoder.decode(url, "UTF-8");
            // 请求发送成功，并得到响应 
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(),"utf-8");
                    if (noNeedResponse) {
                        return null;
                    }
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.fromObject(str);
                } catch (Exception e) {
//					logger.error(MessageSourceExt.getLocaleMessage("framework.util.029", "post请求提交失败:") + url, e);
                }
            }
        } catch (IOException e) {
//			logger.error(MessageSourceExt.getLocaleMessage("framework.util.029", "post请求提交失败:") + url, e);
        }
        return jsonResult;
    }


    /**
     * 发送get请求
     * 
     * @param url [路径]
     * @return
     */
    public static JSONObject httpGet(String url) {
        // get请求返回结果
        JSONObject jsonResult = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            // 发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            // 请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 读取服务器返回过来的json字符串数据
                String strResult = EntityUtils.toString(response.getEntity());
                // 把json字符串转换成json对象
                jsonResult = JSONObject.fromObject(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
//				logger.error(MessageSourceExt.getLocaleMessage("framework.util.030", "get请求提交失败:") + url);
            }
        } catch (IOException e) {
//			logger.error(MessageSourceExt.getLocaleMessage("framework.util.030", "get请求提交失败:") + url, e);
        }
        return jsonResult;
    }
    
    /**
     * 发送get请求
     * 
     * @param url [路径]
     * @return
     */
    public static String get(String url) {
        String strResult = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            // 发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            // 请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 读取服务器返回过来的json字符串数据
                strResult = EntityUtils.toString(response.getEntity());
                url = URLDecoder.decode(url, "UTF-8");
            } else {
//                logger.error(MessageSourceExt.getLocaleMessage("framework.util.030", "get请求提交失败:") + url);
            }
        } catch (IOException e) {
//            logger.error(MessageSourceExt.getLocaleMessage("framework.util.030", "get请求提交失败:") + url, e);
        }
        return strResult;
    }
    
    /**
     * post请求
     * 
     * @param url [url地址]
     * @param jsonParam [参数]
     * @return
     */
    public static String post(String url, JSONObject jsonParam) {
        // post请求返回结果
        String strResult = null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            // 请求发送成功，并得到响应 
            if (result.getStatusLine().getStatusCode() == 200) {
                try {
                    // 读取服务器返回过来的json字符串数据
                    strResult = EntityUtils.toString(result.getEntity());
                } catch (Exception e) {
//                    logger.error(MessageSourceExt.getLocaleMessage("framework.util.029", "post请求提交失败:") + url, e);
                }
            }
        } catch (IOException e) {
//            logger.error(MessageSourceExt.getLocaleMessage("framework.util.029", "post请求提交失败:") + url, e);
        }
        return strResult;
    }
    
    /**
     * 发送get请求
     * 
     * @param url [路径]
     * @return
     */
    public static JSONArray httpGetWithJSONArray(String url) {
        // get请求返回结果
        JSONArray jsonResult = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            // 发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            // 请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 读取服务器返回过来的json字符串数据
                String strResult = EntityUtils.toString(response.getEntity());
                // 把json字符串转换成json对象
                jsonResult = JSONArray.fromObject(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
//                logger.error(MessageSourceExt.getLocaleMessage("framework.util.030", "get请求提交失败:") + url);
            }
        } catch (IOException e) {
//            logger.error(MessageSourceExt.getLocaleMessage("framework.util.030", "get请求提交失败:") + url, e);
        }
        return jsonResult;
    }
    
    /**
     * post请求
     * 
     * @param url [url地址]
     * @param jsonParam [参数]
     * @return
     */
    public static JSONArray httpPostWithJSONArray(String url, JSONObject jsonParam) {
        // post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        JSONArray jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            // 请求发送成功，并得到响应 
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity());
                    // 把json字符串转换成json对象
                    jsonResult = JSONArray.fromObject(str);
                } catch (Exception e) {
//                    logger.error(MessageSourceExt.getLocaleMessage("framework.util.029", "post请求提交失败:") + url, e);
                }
            }
        } catch (IOException e) {
//            logger.error(MessageSourceExt.getLocaleMessage("framework.util.029", "post请求提交失败:") + url, e);
        }
        return jsonResult;
    }
    
    /**
     * 发送get请求,返回Map类型数据
     * @param url [请求URL]
     * @return
     */
    public static Map<String, Object> httpGetWithMap(String url) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        JSONObject jsonObject = httpGet(url);
        if(jsonObject!=null){
            Iterator it = jsonObject.keys();
            // 遍历jsonObject数据，添加到Map对象
            while (it.hasNext()) {
                String key = String.valueOf(it.next());
                data.put(key, jsonObject.get(key));
            }
            return data;
        }
        return null;
    }
    
    /**
     * post请求，返回Map类型数据
     * @param url
     * @param jsonParam
     * @return
     */
    public static Map<String, Object> httpPostWithMap(String url, JSONObject jsonParam){
        HashMap<String, Object> data = new HashMap<String, Object>();
        JSONObject jsonObject = httpPost(url, jsonParam);
        if(jsonObject!=null){
            Iterator it = jsonObject.keys();
            // 遍历jsonObject数据，添加到Map对象
            while (it.hasNext()) {
                String key = String.valueOf(it.next());
                data.put(key, jsonObject.get(key));
            }
            return data;
        }
        return null;
    }
    
    /**
     * 发送get请求,返回List类型数据
     * @param url [请求URL]
     * @return
     */
    public static List<Map<String, Object>> httpGetWithList(String url) {
        JSONArray jsonArray = httpGetWithJSONArray(url);
        if(jsonArray!=null){
            List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
            HashMap<String, Object> map = null;
            for(int i=0;i<jsonArray.size();i++){
                map = new HashMap<String, Object>();
                JSONObject jObject = (JSONObject)jsonArray.get(i);
                Iterator it = jObject.keys();
                // 遍历jsonObject数据，添加到Map对象
                while (it.hasNext()) {
                    String key = String.valueOf(it.next());
                    map.put(key, jObject.get(key));
                }
                data.add(map);
            }
            return data;
        }
        return null;
    }
    
    /**
     * post请求，返回List类型数据
     * @param url
     * @param jsonParam
     * @return
     */
    public static List<Map<String, Object>> httpPostWithList(String url, JSONObject jsonParam){
        JSONArray jsonArray = httpPostWithJSONArray(url, jsonParam);
        if(jsonArray!=null){
            List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
            HashMap<String, Object> map = null;
            for(int i=0;i<jsonArray.size();i++){
                map = new HashMap<String, Object>();
                JSONObject jObject = (JSONObject)jsonArray.get(i);
                Iterator it = jObject.keys();
                // 遍历jsonObject数据，添加到Map对象
                while (it.hasNext()) {
                    String key = String.valueOf(it.next());
                    map.put(key, jObject.get(key));
                }
                data.add(map);
            }
            return data;
        }
        return null;
    }

    /**
     * post请求
     * @param url   发送的url
     * @param param 传入参数为Map类型
     * @return
     */
    public static String getPostMap(String url,String param){
        String result="";
        try{
            HttpPost httpPost = new HttpPost(url);
//            httpPost.setHeader("Accept","application/json");
//            httpPost.setHeader("Content-type","application/json");
            StringEntity stringEntity = new StringEntity(param);//param参数，可以为"key1=value1&key2=value2"的一串字符串
            stringEntity.setContentType("application/x-www-form-urlencoded");
            httpPost.setEntity(stringEntity);
            HttpClient client = new DefaultHttpClient();
            HttpResponse httpResponse = client.execute(httpPost);
             result = EntityUtils.toString(httpResponse.getEntity(), HTTP.UTF_8);
        } catch(IOException e){
        }

        return result;
    }

    /**
     * post请求 效果与getPostMap相同
     * @param url   发送的url
     * @param param 传入参数跟get请求差不多，例如： company=111111
     * @return
     */
    public static String getPostMap2(String url,String param){
        String result="";
        try{
            url=url+"?"+param;
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Accept","application/json");
            httpPost.setHeader("Content-type","application/json");
            HttpClient client = new DefaultHttpClient();
            HttpResponse httpResponse = client.execute(httpPost);
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                HttpEntity entity= httpResponse.getEntity();
                if(null!=entity){
                    result = EntityUtils.toString(entity, HTTP.UTF_8);
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }


    /**
     * @Description:使用HttpURLConnection发送post请求
     * @author:liuyc
     * @time:2016年5月17日 下午3:26:07
     */
    public static String sendPost(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> e : params.entrySet()) {
                sbParams.append(e.getKey());
                sbParams.append("=");
                sbParams.append(e.getValue());
                sbParams.append("&");
            }
        }
        HttpURLConnection con = null;
        OutputStreamWriter osw = null;
        BufferedReader br = null;
        // 发送请求
        try {
            URL url = new URL(urlParam);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (sbParams != null && sbParams.length() > 0) {
                osw = new OutputStreamWriter(con.getOutputStream(), charset);
                osw.write(sbParams.substring(0, sbParams.length() - 1));
                osw.flush();
            }
            // 读取返回内容
            resultBuffer = new StringBuffer();
            int contentLength = Integer.parseInt(con.getHeaderField("Content-Length"));
            if (contentLength > 0) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
                String temp;
                while ((temp = br.readLine()) != null) {
                    resultBuffer.append(temp);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    osw = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
        }

        return resultBuffer.toString();
    }

    /**
     * @Description:使用URLConnection发送post
     * @author:liuyc
     * @time:2016年5月17日 下午3:26:52
     */
    public static String sendPost2(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> e : params.entrySet()) {
                sbParams.append(e.getKey());
                sbParams.append("=");
                sbParams.append(e.getValue());
                sbParams.append("&");
            }
        }
        URLConnection con = null;
        OutputStreamWriter osw = null;
        BufferedReader br = null;
        try {
            URL realUrl = new URL(urlParam);
            // 打开和URL之间的连接
            con = realUrl.openConnection();
            // 设置通用的请求属性
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("connection", "Keep-Alive");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            con.setDoOutput(true);
            con.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            osw = new OutputStreamWriter(con.getOutputStream(), charset);
            if (sbParams != null && sbParams.length() > 0) {
                // 发送请求参数
                osw.write(sbParams.substring(0, sbParams.length() - 1));
                // flush输出流的缓冲
                osw.flush();
            }
            // 定义BufferedReader输入流来读取URL的响应
            resultBuffer = new StringBuffer();
            int contentLength = Integer.parseInt(con.getHeaderField("Content-Length"));
            if (contentLength > 0) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
                String temp;
                while ((temp = br.readLine()) != null) {
                    resultBuffer.append(temp);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    osw = null;
                    throw new RuntimeException(e);
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                }
            }
        }
        return resultBuffer.toString();
    }

    /**
     * @Description:发送get请求保存下载文件
     * @author:liuyc
     * @time:2016年5月17日 下午3:27:29
     */
    public static void sendGetAndSaveFile(String urlParam, Map<String, Object> params, String fileSavePath) {
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        HttpURLConnection con = null;
        BufferedReader br = null;
        FileOutputStream os = null;
        try {
            URL url = null;
            if (sbParams != null && sbParams.length() > 0) {
                url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));
            } else {
                url = new URL(urlParam);
            }
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.connect();
            InputStream is = con.getInputStream();
            os = new FileOutputStream(fileSavePath);
            byte buf[] = new byte[1024];
            int count = 0;
            while ((count = is.read(buf)) != -1) {
                os.write(buf, 0, count);
            }
            os.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    os = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
        }
    }

    /**
     * @Description:使用HttpURLConnection发送get请求
     * @author:liuyc
     * @time:2016年5月17日 下午3:27:29
     */
    public static String sendGet(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        HttpURLConnection con = null;
        BufferedReader br = null;
        try {
            URL url = null;
            if (sbParams != null && sbParams.length() > 0) {
                url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));
            } else {
                url = new URL(urlParam);
            }
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.connect();
            resultBuffer = new StringBuffer();
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
            String temp;
            while ((temp = br.readLine()) != null) {
                resultBuffer.append(temp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
        }
        return resultBuffer.toString();
    }

    /**
     * @Description:使用URLConnection发送get请求
     * @author:liuyc
     * @time:2016年5月17日 下午3:27:58
     */
    public static String sendGet2(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        BufferedReader br = null;
        try {
            URL url = null;
            if (sbParams != null && sbParams.length() > 0) {
                url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));
            } else {
                url = new URL(urlParam);
            }
            URLConnection con = url.openConnection();
            // 设置请求属性
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("connection", "Keep-Alive");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立连接
            con.connect();
            resultBuffer = new StringBuffer();
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
            String temp;
            while ((temp = br.readLine()) != null) {
                resultBuffer.append(temp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                }
            }
        }
        return resultBuffer.toString();
    }

    /**
     * @Description:使用HttpClient发送post请求
     * @author:liuyc
     * @time:2016年5月17日 下午3:28:23
     */
    public static String httpClientPost(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(urlParam);
        // 构建请求参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> elem = iterator.next();
            list.add(new BasicNameValuePair(elem.getKey(), String.valueOf(elem.getValue())));
        }
        BufferedReader br = null;
        try {
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = client.execute(httpPost);
            // 读取服务器响应数据
            resultBuffer = new StringBuffer();
            br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String temp;
            while ((temp = br.readLine()) != null) {
                resultBuffer.append(temp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                }
            }
        }
        return resultBuffer.toString();
    }

    /**
     * @Description:使用HttpClient发送get请求
     * @author:liuyc
     * @time:2016年5月17日 下午3:28:56
     */
    public static String httpClientGet(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;
        HttpClient client = new DefaultHttpClient();
        BufferedReader br = null;
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                try {
                    sbParams.append(URLEncoder.encode(String.valueOf(entry.getValue()), charset));
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
                sbParams.append("&");
            }
        }
        if (sbParams != null && sbParams.length() > 0) {
            urlParam = urlParam + "?" + sbParams.substring(0, sbParams.length() - 1);
        }
        HttpGet httpGet = new HttpGet(urlParam);
        try {
            HttpResponse response = client.execute(httpGet);
            // 读取服务器响应数据
            br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String temp;
            resultBuffer = new StringBuffer();
            while ((temp = br.readLine()) != null) {
                resultBuffer.append(temp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                }
            }
        }
        return resultBuffer.toString();
    }

    /**
     * @Description:使用socket发送post请求
     * @author:liuyc
     * @time:2016年5月18日 上午9:26:22
     */
    public static String sendSocketPost(String urlParam, Map<String, Object> params, String charset) {
        String result = "";
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        Socket socket = null;
        OutputStreamWriter osw = null;
        InputStream is = null;
        try {
            URL url = new URL(urlParam);
            String host = url.getHost();
            int port = url.getPort();
            if (-1 == port) {
                port = 80;
            }
            String path = url.getPath();
            socket = new Socket(host, port);
            StringBuffer sb = new StringBuffer();
            sb.append("POST " + path + " HTTP/1.1\r\n");
            sb.append("Host: " + host + "\r\n");
            sb.append("Connection: Keep-Alive\r\n");
            sb.append("Content-Type: application/x-www-form-urlencoded; charset=utf-8 \r\n");
            sb.append("Content-Length: ").append(sb.toString().getBytes().length).append("\r\n");
            // 这里一个回车换行，表示消息头写完，不然服务器会继续等待
            sb.append("\r\n");
            if (sbParams != null && sbParams.length() > 0) {
                sb.append(sbParams.substring(0, sbParams.length() - 1));
            }
            osw = new OutputStreamWriter(socket.getOutputStream());
            osw.write(sb.toString());
            osw.flush();
            is = socket.getInputStream();
            String line = null;
            // 服务器响应体数据长度
            int contentLength = 0;
            // 读取http响应头部信息
            do {
                line = readLine(is, 0, charset);
                if (line.startsWith("Content-Length")) {
                    // 拿到响应体内容长度
                    contentLength = Integer.parseInt(line.split(":")[1].trim());
                }
                // 如果遇到了一个单独的回车换行，则表示请求头结束
            } while (!line.equals("\r\n"));
            // 读取出响应体数据（就是你要的数据）
            result = readLine(is, contentLength, charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    osw = null;
                    throw new RuntimeException(e);
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            socket = null;
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    throw new RuntimeException(e);
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            socket = null;
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * @Description:使用socket发送get请求
     * @author:liuyc
     * @time:2016年5月18日 上午9:27:18
     */
    public static String sendSocketGet(String urlParam, Map<String, Object> params, String charset) {
        String result = "";
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        Socket socket = null;
        OutputStreamWriter osw = null;
        InputStream is = null;
        try {
            URL url = new URL(urlParam);
            String host = url.getHost();
            int port = url.getPort();
            if (-1 == port) {
                port = 80;
            }
            String path = url.getPath();
            socket = new Socket(host, port);
            StringBuffer sb = new StringBuffer();
            sb.append("GET " + path + " HTTP/1.1\r\n");
            sb.append("Host: " + host + "\r\n");
            sb.append("Connection: Keep-Alive\r\n");
            sb.append("Content-Type: application/x-www-form-urlencoded; charset=utf-8 \r\n");
            sb.append("Content-Length: ").append(sb.toString().getBytes().length).append("\r\n");
            // 这里一个回车换行，表示消息头写完，不然服务器会继续等待
            sb.append("\r\n");
            if (sbParams != null && sbParams.length() > 0) {
                sb.append(sbParams.substring(0, sbParams.length() - 1));
            }
            osw = new OutputStreamWriter(socket.getOutputStream());
            osw.write(sb.toString());
            osw.flush();
            is = socket.getInputStream();
            String line = null;
            // 服务器响应体数据长度
            int contentLength = 0;
            // 读取http响应头部信息
            do {
                line = readLine(is, 0, charset);
                if (line.startsWith("Content-Length")) {
                    // 拿到响应体内容长度
                    contentLength = Integer.parseInt(line.split(":")[1].trim());
                }
                // 如果遇到了一个单独的回车换行，则表示请求头结束
            } while (!line.equals("\r\n"));
            // 读取出响应体数据（就是你要的数据）
            result = readLine(is, contentLength, charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    osw = null;
                    throw new RuntimeException(e);
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            socket = null;
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    throw new RuntimeException(e);
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            socket = null;
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * @Description:读取一行数据，contentLe内容长度为0时，读取响应头信息，不为0时读正文
     * @time:2016年5月17日 下午6:11:07
     */
    private static String readLine(InputStream is, int contentLength, String charset) throws IOException {
        List<Byte> lineByte = new ArrayList<Byte>();
        byte tempByte;
        int cumsum = 0;
        if (contentLength != 0) {
            do {
                tempByte = (byte) is.read();
                lineByte.add(Byte.valueOf(tempByte));
                cumsum++;
            } while (cumsum < contentLength);// cumsum等于contentLength表示已读完
        } else {
            do {
                tempByte = (byte) is.read();
                lineByte.add(Byte.valueOf(tempByte));
            } while (tempByte != 10);// 换行符的ascii码值为10
        }

        byte[] resutlBytes = new byte[lineByte.size()];
        for (int i = 0; i < lineByte.size(); i++) {
            resutlBytes[i] = (lineByte.get(i)).byteValue();
        }
        return new String(resutlBytes, charset);
    }
}
