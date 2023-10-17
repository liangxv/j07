package com.woniuxy.pojo;

import java.io.InputStream;
import java.util.Properties;

public class CarFactory {
    public static Car createCar(String type){
        Properties properties =new Properties();
        try (InputStream inputStream = Car.class.getResourceAsStream("/car.properties")){
            properties.load(inputStream);
            String classname = properties.getProperty(type);
            if (classname==null) {
                throw new IllegalArgumentException("无效的汽车类型"+type);
            }
            Class<?> name = Class.forName(classname);
            return (Car) name.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
