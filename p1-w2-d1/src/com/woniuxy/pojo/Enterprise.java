package com.woniuxy.pojo;

import java.util.Arrays;

public class Enterprise {
    private String[] companies;
    private String enterpriseName;
    private String establishedTime;

    public Enterprise(String[] companies) {
        this.companies = companies;
    }

    public void listAllEnterprises() {
        for (int i = 0; i < companies.length; i++) {
            String company = companies[i];
            String[] split = company.split("-");
            enterpriseName = split[0];
            establishedTime = split[1];
            System.out.println("索引 " + i + "\t企业 " + enterpriseName + "\t成立时间 " + establishedTime);
        }
    }

    public void findEnterpriseByName(String enterpriseName) {
        for (int i = 0; i < companies.length; i++) {
            String company = companies[i];
            String[] split = company.split("-");
            if (split[0].contains(enterpriseName)) {
                establishedTime = split[1];
                System.out.println("索引 " + i + "\t企业: " + split[0] + "\t成立时间: " + establishedTime);
            }
        }
    }

    public int countEnterprisesByName(String enterpriseName) {
        int count = 0;
        for (String company : companies) {
            String[] split = company.split("-");
            if (split[0].contains(enterpriseName)) {
                count++;
            }
        }
        System.out.println("一共有 " + count + " 家企业");
        return count;
    }

    public void findEnterprisesByTimeRange(int low, int high) {
        for (int i = 0; i < companies.length; i++) {
            String company = companies[i];
            String[] split = company.split("-");
            int time = Integer.parseInt(split[1]);
            if (time >= low && time <= high) {
                enterpriseName = split[0];
                establishedTime = split[1];
                System.out.println("索引 " + i + "\t企业: " + enterpriseName + "\t成立时间: " + establishedTime);
            }
        }
    }

    public void addEnterprise(String enterpriseName, String establishedTime) {
        String newEntry = enterpriseName + "-" + establishedTime;
        companies = Arrays.copyOf(companies, companies.length + 1);
        companies[companies.length - 1] = newEntry;
        System.out.println("添加成功");
    }

    public void updateEnterprise(int index, String enterpriseName, String establishedTime) {
        if (index >= 0 && index < companies.length) {
            companies[index] = enterpriseName + "-" + establishedTime;
            System.out.println("修改成功");
        } else {
            System.out.println("索引无效，企业修改失败");
        }
    }

    public void deleteEnterprise(int index) {
        if (index >= 0 && index < companies.length) {
            System.arraycopy(companies, index + 1, companies, index, companies.length - index - 1);
            companies = Arrays.copyOf(companies, companies.length - 1);
            System.out.println("删除企业成功！");
        } else {
            System.out.println("索引无效，企业删除失败");
        }
    }
}
