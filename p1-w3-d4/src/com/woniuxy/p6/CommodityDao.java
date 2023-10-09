package com.woniuxy.p6;


import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommodityDao implements CommodityD{

    final static String DB_FILE = "F:\\workspace\\j07\\p1-w3-d4\\src\\commodity.txt";

    private List<Commodity> commodities;

    public CommodityDao() {
        commodities = fileToList();
    }

    @Override
    public Commodity findById(int id) {
        for (Commodity commodity : commodities) {
            if (commodity.getId() == id) {
                return commodity;
            }
        }
        return null;
    }

    @Override
    public List<Commodity> findAll() {
        return fileToList();
    }

    private List<Commodity> fileToList() {
        List<Commodity> Commodity = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(DB_FILE))) {
            String data;
            while ((data = in.readLine()) != null) {
                Commodity.add(convertToCommodity(data));
            }
            return Commodity;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Commodity convertToCommodity(String data) {
        String[] split = data.split("-");
        int id = Integer.parseInt(split[0]);
        String name = split[1];
        int price = Integer.parseInt(split[2]);
        String type = split[3];
        return new Commodity(id, name, price, type);
    }

    public Commodity createCommodity(int id, String name, int price, String type) {
        id = nextId();
        return new Commodity(id, name, price, type);
    }

    // 获取下一个可用的商品ID
    private int nextId() {
        return commodities.stream().mapToInt(Commodity::getId).max().orElse(0) + 1;
    }

    @Override
    // 添加员工
    public void addCommodity(Commodity commodity) {
        commodities.add(commodity);
        List<String> list = commodities.stream().map(this::convertToString).collect(Collectors.toList());
        writeToFile(list);
    }

    private void writeToFile(List<String> list) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(DB_FILE))) {
            for (String s : list) {
                out.write(s);
                out.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String convertToString(Commodity commodity) {
        return commodity.getId() + "-" +
                commodity.getName() + "-" +
                commodity.getPrice() + "-" +
                commodity.getType();
    }

    @Override
    public void delCommodity(int id) {
        List<String> list = commodities.stream().filter(commodity -> commodity.getId() != id).map(this::convertToString).collect(Collectors.toList());
        writeToFile(list);
    }

    @Override
    public void updateCommodity(int id, Commodity commodity) {
        commodities.forEach(c -> {
            if (c.getId() == id) {
                c.updateFrom(commodity);
            }
        });
        List<String> list = commodities.stream().map(this::convertToString).collect(Collectors.toList());
        writeToFile(list);
    }

    @Override
    public List<Commodity> findByType(String type) {
        return commodities.stream().filter(commodity -> commodity.getType().equals(type)).collect(Collectors.toList());
    }

    @Override
    public Map<String, Long> groupCommodityByTypename() {
        return commodities.stream().collect(Collectors.groupingBy(Commodity::getType, Collectors.counting()));
    }

    @Override
    public List<Commodity> sortCommoditiesByPrice(boolean ascending) {
        if (ascending) {
            commodities.sort(Comparator.comparingInt(Commodity::getPrice));
        } else {
            commodities.sort((c1, c2) -> Integer.compare(c2.getPrice(), c1.getPrice()));
        }
        return commodities;
    }

    @Override
    public Map<String, List<Commodity>> groupCommodityByType() {
        return commodities.stream().collect(Collectors.groupingBy(Commodity::getType, Collectors.toList()));
    }
}
