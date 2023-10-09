package com.woniuxy.p5;

import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
    /**
     * 创建对象
     */
    public static EmployeeDao createObject(String type) {
        //创建属性对象
        Properties properties = new Properties();
        //读取属性文件
        try(InputStream inputStream =
                    BeanFactory.class.getResourceAsStream("/employee.properties")) {
            //加载属性文件
            properties.load(inputStream);
            //获取类全名
            String classString = properties.getProperty(type);
            //得到类对象
            Class<EmployeeDao> classObject = (Class<EmployeeDao>)
                    Class.forName(classString);
            //通过反射实例化对象
            return classObject.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
