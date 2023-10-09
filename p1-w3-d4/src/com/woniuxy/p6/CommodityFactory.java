package com.woniuxy.p6;

import java.io.InputStream;
import java.util.Properties;

public class CommodityFactory {
    public static CommodityDao createObject(String type){
        //创建属性对象
        Properties properties = new Properties();
        try (InputStream inputStream = CommodityFactory.class.getResourceAsStream("/commodity.properties")){
            properties.load(inputStream);
            String classString = properties.getProperty(type);
            Class<CommodityDao> classObject = (Class<CommodityDao>) Class.forName(classString);
            return classObject.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
