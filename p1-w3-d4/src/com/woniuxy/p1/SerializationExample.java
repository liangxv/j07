package com.woniuxy.p1;

import java.io.*;

class MyClass implements Serializable {
    private static final long serialVersionUID = 1L; // 自定义序列化 ID
    private int id;
    private String name;
    private transient String transientField; // transient 字段

    public MyClass(int id, String transientField) {
        this.id = id;
        this.transientField = transientField;
    }

    public int getId() {
        return id;
    }

    public String getTransientField() {
        return transientField;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        // 序列化对象
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
//            MyClass obj = new MyClass(1, "This field will not be serialized");
//            oos.writeObject(obj);
//            System.out.println("Object serialized successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 反序列化对象
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"))) {
            MyClass newObj = (MyClass) ois.readObject();
            System.out.println("Object deserialized successfully.");
            System.out.println("ID: " + newObj.getId());
            System.out.println("Transient Field: " + newObj.getTransientField()); // transient 字段被初始化为 null
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
