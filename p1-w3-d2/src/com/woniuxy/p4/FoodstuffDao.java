package com.woniuxy.p4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FoodstuffDao {
    private  String filePath;



    public FoodstuffDao(String filePath) {
        this.filePath = filePath;
    }

    // 读取食物列表数据并返回
    public List<String> readFoodstuff() {
        List<String> foodstuffList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                foodstuffList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foodstuffList;
    }

    // 获取所有食物
    public List<String> findAll() {
        return readFoodstuff();
    }

    // 根据关键字查询食物
    public List<String> findByKeywords(String keyword) {
        List<String> foodstuffList = readFoodstuff();
        return foodstuffList.stream().filter(food -> food.contains(keyword)).collect(Collectors.toList());
    }

    // 创建用于写入的 BufferedWriter
    private BufferedWriter createWriter() throws IOException {
        return new BufferedWriter(new FileWriter(filePath));
    }

    // 更新食物列表数据
    private void updateFoodstuffList(List<String> foodstuffList) {
        try (BufferedWriter writer = createWriter()) {
            for (String foodstuff : foodstuffList) {
                writer.write(foodstuff);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 添加食物
    public void addFoodstuff(String foodstuff) {
        List<String> foodstuffList = readFoodstuff();
        foodstuffList.add(foodstuff);
        updateFoodstuffList(foodstuffList);
    }

    // 删除食物
    public void delFoodstuff(String foodstuff) {
        List<String> foodstuffList = readFoodstuff();
        foodstuffList.remove(foodstuff);
        updateFoodstuffList(foodstuffList);
    }

    public int getIndex(String s,List<String> list){
        return list.indexOf(s);
    }

    //修改食物
    public void updateFoodstuff(String e, String s) {
        List<String> foodstuffList = readFoodstuff();
        int index;

        while ((index = getIndex(s, foodstuffList)) != -1) {
            foodstuffList.set(index, e);
        }

        updateFoodstuffList(foodstuffList);
    }

}



