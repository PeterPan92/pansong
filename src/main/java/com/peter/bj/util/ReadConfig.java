package com.peter.bj.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author panxinbing
 *         create time:  2018/4/27.
 */
public class ReadConfig {

    /**
     * 利用resourceBundle方法获取文件属性方法.
     * @param key  属性值的key
     * @param fileName  属性文件的名称，不包含.properties
     *                    例如文件名为config/ChatController.properties,输入的参数为config/ChatController
     * @return
     */
    public  String getConfig(String key, String fileName){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(fileName);
        //国际化内容
        // ResourceBundle resourceBundle = ResourceBundle.getBundle("greeding", Locale.CHINA);
        return resourceBundle.getObject(key).toString();
    }

    /**
     * 利用类的反射机制获取文件的属性信息.
     * @param key 属性值的key
     * @param fileName 属性文件的名称，包含.properties
     *                    例如文件名为/config/ChatController.properties,输入的参数为/config/ChatController.properties
     * @throws Exception
     */
    public  String getConfig2(String key,String fileName) throws Exception{
        Properties prop = new Properties();
        //配置文件夹下的内容
        InputStream inpstStream = Object.class.getResourceAsStream(fileName);
        prop.load(inpstStream);
        //设置默认属性值   prop.getProperty("welcome", "Test");  输出为welcome的内容为Test
        //设置属性值 prop.setProperty("nihao","good");
        return prop.getProperty(key);
    }

    /**
     * 利用fileInputStream.
     * @param key 属性值的key
     * @param fileName  属性文件的名称，包含.properties  应该写绝对路径，尽量使用1、2获取文件属性值
     *                    例如文件名为/config/ChatController.properties,输入的参数为resources/config/ChatController.properties
     * @throws Exception
     */
    public  String getConfig3(String key,String fileName)throws Exception{
        FileInputStream fis = new FileInputStream (fileName);
        Properties properties = new Properties();
        properties.load(fis);
        return properties.getProperty(key).toString();
    }

    /**
     * 获取工程的名字.
     * @return 工程的名称
     */
   public  String getProjectName(){
       //取当前类所在的工程名：
       String projectName = System.getProperty ("user.dir");
       return projectName;
   }


}
