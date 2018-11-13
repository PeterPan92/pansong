package com.peter.bj.util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLUtil {
    javax.xml.xpath.XPath oXpath;  
    /** 
     * 构造xml文档对应的document对象 
     * @param file 
     * @return 
     * @throws Exception 
     */  
    private Document parseFile(File file) throws Exception  
    {  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        dbf.setValidating(false);  
        DocumentBuilder db = dbf.newDocumentBuilder();  
        Document doc = db.parse(file);
  
        // 创建XPath对象  
        XPathFactory factory = XPathFactory.newInstance();  
        oXpath = factory.newXPath();  
        return doc;  
    }  
    /** 
     * 构造输入流对应的document对象 
     * @param in 
     * @return 
     * @throws Exception 
     */  
    private Document parseStream(InputStream in) throws Exception  
    {  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        dbf.setValidating(false);  
        DocumentBuilder db = dbf.newDocumentBuilder();  
        Document doc = db.parse(in);
  
        // 创建XPath对象  
        XPathFactory factory = XPathFactory.newInstance();  
        oXpath = factory.newXPath();  
        return doc;  
    }  
    /** 
     * 获取结点值 
     * @param node 
     * @return 
     */  
    private String getNodeValue(Node node)  
    {  
        String dataValue = node.getTextContent();  
        return dataValue;  
    }  
    /** 
     * 获取结点List 
     * @param node 
     * @param xpath 
     * @return 
     * @throws XPathExpressionException 
     */  
    private NodeList getNodeList(Node node, String xpath) throws XPathExpressionException
    {  
        NodeList nodeList = (NodeList) oXpath.evaluate(xpath, node, XPathConstants.NODESET);  
  
        return nodeList;  
    }  
    /** 
     * 获取单个结点 
     * @param node 
     * @param xpath 
     * @return 
     * @throws XPathExpressionException 
     */  
    private Node getNode(Node node, String xpath) throws XPathExpressionException
    {  
        Node nodeRet = (Node) oXpath.evaluate(xpath, node, XPathConstants.NODE);  
  
        return nodeRet;  
    }
    /**
     * 将inputStream转换为String
     * @param in_st
     * @return
     * @throws IOException
     */
    private  String inputStream2String(InputStream in_st) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(in_st));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null){
          buffer.append(line);
        }
        return buffer.toString();
    }
    /**
     * 将String转化为inputStream
     * @param str
     * @return
     */
    private  InputStream String2InputStream(String str){
        ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
        return stream;
    }
    
    /**
     * 封装xml处理的结果
     * @param result 成功或失败返回的结果
     * @param status 成功或失败的标志fail/success
     * @param detail 对返回结果的详细说明
     * @return
     */
    private Map<String,String> wrapResult(String result,String status,String detail){
        Map<String,String> xPathResult = new HashMap<String,String>();
        xPathResult.put("result", result);
        xPathResult.put("status", status);
        xPathResult.put("detail", detail);
        xPathResult.put("totalParamSize", "");
        xPathResult.put("currentParamSize", "");
        xPathResult.put("sententceParam", "");
        return xPathResult;
    }
    

    /**
     * 使用xpath提取结果
     * @param inputXmlString 服务返回的xml的String结果
     * @param successAns 用户输入的成功匹配模板
     * @param failAns 失败模板
     * @param param
     * @return
     */
    public Map<String,String> getXMLResult(String inputXmlString, String successAns,String failAns,List<Map<String,String>> param){
        
        //使用正则表达式获取获取xpath中的内容
        String urlPattern = "\\%\\(.*?\\)";
        String xpathPattern = "\\#\\(.*?\\)";
        Pattern urlPat = Pattern.compile(urlPattern);
        Pattern xpathPat = Pattern.compile(xpathPattern);
        
        Matcher urlMatcher = urlPat.matcher(successAns);
        Matcher xpathMatcher = xpathPat.matcher(successAns);
        
        //处理句子中的从url中获取的参数值
        while(urlMatcher.find()){
            String nameP =urlMatcher.group();
            String name = nameP.substring(2,nameP.length()-1);
            if(param!=null &&param.size()>0){
                Optional<Map<String, String>> urlParam = param.stream().filter(
                        aa->(aa.containsKey("paramName")&&aa.get("paramName").equals(name))).findFirst();
                //如果在参数列表中找到模板中的语句，将参数替换为对应的值
                if(urlParam.isPresent()){
                    Map<String, String> urlParamMap = urlParam.get();
                    successAns = successAns.replace(nameP, urlParamMap.get("element"));
                }else{
                    Map<String,String> xPathResult = wrapResult(failAns,"fail","从url中获取的参数值失败");
                    return  xPathResult;
                }
            }
        }
        
        //处理#()部分，从返回结果中取值
        while(xpathMatcher.find()){
            String nameP = xpathMatcher.group();
          //如果句子中包含#()说明返回的语句为string，则进行处理
            if("#()".equals(nameP)){
                successAns = successAns.replace(nameP, inputXmlString);
                break;
            }else{
                //#("xxxx")说明返回的结果为xpath内容,解析并进行匹配
                InputStream inputxmlStream= String2InputStream(inputXmlString);
                try {
                    //生成xml document
                    Document xmlDoc = parseStream(inputxmlStream);
                    //获取xpath表达式
                    String name = nameP.substring(2,nameP.length()-1);
                    //获取节点
                    Node node= getNode(xmlDoc,name);
                    //获取节点的值
                    String nodeValue = getNodeValue(node);
                    //判断解析结果是否正确，如果正确，则将原句中的值进行替换
                    if(null!=nodeValue&&(!nodeValue.equals("[]"))&&(nodeValue.length()>0)&&(!"null".equals(nodeValue))){
                        successAns = successAns.replace(nameP, nodeValue);
                    }else{
                        Map<String,String> xPathResult = wrapResult(failAns,"fail","xPath定义错误");
                        return xPathResult;
                    }
                    
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    Map<String,String> xPathResult = wrapResult(failAns,"fail","xPath定义错误");
                    return xPathResult;
                }
            }
        }
        Map<String,String> xPathResult = wrapResult(successAns,"success","应答模块参数提取成功");
        return xPathResult;    
    }
}
