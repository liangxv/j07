package com.woniuxy.p9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao {
    final static String DB_FILE = "F:\\workspace\\j07\\p1-w3-d3\\src\\com\\woniuxy\\p9\\test.txt";

    public List<Company> fileToList() {
        List<Company> companies = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(DB_FILE))) {
            String data;
            while ((data = in.readLine()) != null) {
                companies.add(convertToCompany(data));
            }
            return companies;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Company convertToCompany(String str) {
        String[] split = str.split("-");
        int id = Integer.parseInt(split[0]);
        String name = split[1];
        String boss = split[2];
        int year = Integer.parseInt(split[3]);
        return new Company(id, name, boss, year);

    }

    // 查询所有公司
    public List<Company> findAll() {
        return fileToList();
    }
}
