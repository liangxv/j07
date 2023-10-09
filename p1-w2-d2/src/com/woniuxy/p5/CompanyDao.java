package com.woniuxy.p5;

import java.util.ArrayList;

public class CompanyDao {
    // 使用 ArrayList 存储公司信息
    private ArrayList<Company> companyList = new ArrayList<>();

    // 构造函数初始化一些示例数据
    public CompanyDao() {
        companyList.add(new Company(1, "阿里巴巴", 1998, "马云"));
        companyList.add(new Company(2, "腾讯", 1998, "马化腾"));
        companyList.add(new Company(3, "百度", 2000, "李彦宏"));
        companyList.add(new Company(4, "京东", 1998, "刘强东"));
        companyList.add(new Company(5, "网易", 1997, "丁磊"));
        companyList.add(new Company(6, "华为", 1987, "任正非"));
        companyList.add(new Company(7, "美团", 2010, "王兴"));
    }

    // 查询所有公司信息
    public ArrayList<Company> findAll() {
        return companyList;
    }

    // 根据关键字查询公司信息
    public ArrayList<Company> keywordQueryCompany(String keyword) {
        ArrayList<Company> companyListRange = new ArrayList<>();
        for (Company company : companyList) {
            if (company.getName().contains(keyword) || company.getBoss().contains(keyword)) {
                companyListRange.add(company);
            }
        }
        return companyListRange;
    }

    // 根据年份范围查询公司信息
    public ArrayList<Company> timeRangeQueries(int low, int high) {
        ArrayList<Company> companyListRange = new ArrayList<>();
        for (Company company : companyList) {
            if (company.getYear() >= low && company.getYear() <= high) {
                companyListRange.add(company);
            }
        }
        return companyListRange;
    }

    // 添加公司信息
    public void addCompany(Company company) {
        companyList.add(company);
    }

    // 删除公司信息
    public void deleteCompany(int index) {
        // 使用迭代器来遍历并删除符合条件的公司信息
        for (Company company : companyList) {
            if (index == company.getId()) {
                companyList.remove(company);
                break;
            }
        }
    }

    // 按企业成立的时间进行升序排序
    public ArrayList<Company> sortByYearAscending() {
        for (int i = 0; i < companyList.size()-1; i++) {
            for (int j = 0; j < companyList.size()-i-1; j++) {
                if (companyList.get(j).getYear()>companyList.get(j+1).getYear()) {
                    Company temp = companyList.get(j);
                    companyList.set(j,companyList.get(j+1));
                    companyList.set(j+1,temp);

                }
            }
        }
        return companyList;
    }

    // 获取下一个可用的公司 ID
    public int nextId() {
        int max = 0;
        for (Company company : companyList) {
            if (max < company.getId()) {
                max = company.getId();
            }
        }
        return max + 1;
    }
}
