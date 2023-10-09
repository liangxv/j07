package com.woniuxy.p7;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class Factory {

    public static <T> T getBean(String className) {

        Properties properties =new Properties();
        try (InputStream inputStream = Factory.class.getResourceAsStream("/"+className)){
            properties.load(inputStream);
            String classString = properties.getProperty("class");
            Class<T> classObject = (Class<T>) Class.forName(classString);
            T t = classObject.getConstructor().newInstance();
            Field[] fields = classObject.getDeclaredFields();
            for (Field field : fields) {
                String memberVariable = field.getName();
                Class<?> fieldClass = field.getType();
                String propertyValue = properties.getProperty(memberVariable);
                Object convertedValue = convertValue(propertyValue, fieldClass);
                field.setAccessible(true); // 设置成员变量可访问
                field.set(t, convertedValue);
            }
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private static Object convertValue(String propertyValue, Class<?> targetType) {
        if (targetType.equals(int.class)) {
            return Integer.parseInt(propertyValue);
        } else if (targetType.equals(String.class)) {
            return propertyValue;
        } else if (targetType.equals(double.class)) {
            return Double.parseDouble(propertyValue);
        } else {
            // 处理其他类型的转换
            throw new IllegalArgumentException("Unsupported data type: " + targetType);
        }
    }
}
