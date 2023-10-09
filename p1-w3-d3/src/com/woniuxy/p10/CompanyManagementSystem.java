package com.woniuxy.p10;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Company {
    private int id;
    private String name;
    private String boss;
    private int year;

    public Company(int id, String name, String boss, int year) {
        this.id = id;
        this.name = name;
        this.boss = boss;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBoss() {
        return boss;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return id + "-" + name + "-" + boss + "-" + year;
    }
}

class CompanyManagement {
    private List<Company> companies;
    private String dataFile;

    public CompanyManagement(String dataFile) {
        this.dataFile = dataFile;
        companies = new ArrayList<>();
        loadCompanies();
    }

    private void loadCompanies() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String boss = parts[2];
                    int year = Integer.parseInt(parts[3]);
                    companies.add(new Company(id, name, boss, year));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveCompanies() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {
            for (Company company : companies) {
                writer.write(company.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listAllCompanies() {
        companies.forEach(System.out::println);
    }

    public Company findCompanyById(int id) {
        return companies.stream().filter(company -> company.getId() == id).findFirst().orElse(null);
    }

    public void createCompany(int id, String name, String boss, int year) {
        companies.add(new Company(id, name, boss, year));
        saveCompanies();
    }

    public void updateCompany(int id, String name, String boss, int year) {
        Company existingCompany = findCompanyById(id);
        if (existingCompany != null) {
            existingCompany = new Company(id, name, boss, year);
            companies.set(id-1 ,existingCompany);
            saveCompanies();
        } else {
            System.out.println("公司不存在，无法更新。");
        }
    }

    public void deleteCompany(int id) {
        Company existingCompany = findCompanyById(id);
        if (existingCompany != null) {
            companies.remove(existingCompany);
            saveCompanies();
        } else {
            System.out.println("公司不存在，无法删除。");
        }
    }

    public List<Company> findCompaniesByBoss(String bossName) {
        return companies.stream()
                .filter(company -> company.getBoss().equalsIgnoreCase(bossName))
                .collect(Collectors.toList());
    }

    public int countCompaniesByBoss(String bossName) {
        return (int) companies.stream()
                .filter(company -> company.getBoss().equalsIgnoreCase(bossName))
                .count();
    }

    public List<Company> findCompaniesBeforeYear(int year) {
        return companies.stream()
                .filter(company -> company.getYear() < year)
                .collect(Collectors.toList());
    }

    public List<Company> findCompaniesByNameContains(String keyword) {
        return companies.stream()
                .filter(company -> company.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void deleteCompaniesBeforeYear(int year) {
        companies.removeIf(company -> company.getYear() < year);
        saveCompanies();
    }

    public void sortCompaniesByYear(boolean ascending) {
        if (ascending) {
            companies.sort(Comparator.comparingInt(Company::getYear));
        } else {
            companies.sort((c1, c2) -> Integer.compare(c2.getYear(), c1.getYear()));
        }
    }

    public Company getLatestCompany() {
        if (companies.isEmpty()) {
            return null;
        }
        return companies.stream()
                .max(Comparator.comparingInt(Company::getYear))
                .orElse(null);
    }
}

public class CompanyManagementSystem {
    public static void main(String[] args) {
        CompanyManagement companyManagement = new CompanyManagement("F:\\workspace\\j07\\p1-w3-d3\\src\\com\\woniuxy\\p10\\test.txt");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("公司管理系统菜单：");
            System.out.println("1. 查询所有的公司");
            System.out.println("2. 通过编号查询一家公司");
            System.out.println("3. 新建一家公司");
            System.out.println("4. 通过编号修改公司信息");
            System.out.println("5. 通过编号删除一家公司");
            System.out.println("6. 找出某个老板创建的公司");
            System.out.println("7. 统计某个老板创建了几家公司");
            System.out.println("8. 找出指定年份以前创建的公司");
            System.out.println("9. 请找出名称包含\"关键字\"的公司");
            System.out.println("10. 删除指定年份以前创建的公司");
            System.out.println("11. 给所有公司按创建年份进行排序(1升序，0降序)");
            System.out.println("12. 得到“公司创立年份”最晚的公司");
            System.out.println("0. 退出");
            System.out.print("请选择操作: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // 读取换行符

            switch (choice) {
                case 1:
                    companyManagement.listAllCompanies();
                    break;
                case 2:
                    System.out.print("请输入公司编号: ");
                    int idToFind = scanner.nextInt();
                    Company foundCompany = companyManagement.findCompanyById(idToFind);
                    if (foundCompany != null) {
                        System.out.println(foundCompany);
                    } else {
                        System.out.println("找不到该公司。");
                    }
                    break;
                case 3:
                    System.out.print("请输入公司编号: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine();  // 读取换行符
                    System.out.print("请输入公司名字: ");
                    String newName = scanner.nextLine();
                    System.out.print("请输入公司老板: ");
                    String newBoss = scanner.nextLine();
                    System.out.print("请输入公司创立年份: ");
                    int newYear = scanner.nextInt();
                    companyManagement.createCompany(newId, newName, newBoss, newYear);
                    break;
                case 4:
                    System.out.print("请输入要修改的公司编号: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();  // 读取换行符
                    Company companyToUpdate = companyManagement.findCompanyById(idToUpdate);
                    if (companyToUpdate != null) {
                        System.out.print("请输入新的公司名字: ");
                        String updatedName = scanner.nextLine();
                        System.out.print("请输入新的公司老板: ");
                        String updatedBoss = scanner.nextLine();
                        System.out.print("请输入新的公司创立年份: ");
                        int updatedYear = scanner.nextInt();
                        companyManagement.updateCompany(idToUpdate, updatedName, updatedBoss, updatedYear);
                        System.out.println("公司信息已更新。");
                    } else {
                        System.out.println("公司不存在，无法更新。");
                    }
                    break;
                case 5:
                    System.out.print("请输入要删除的公司编号: ");
                    int idToDelete = scanner.nextInt();
                    companyManagement.deleteCompany(idToDelete);
                    break;
                case 6:
                    System.out.print("请输入老板名字: ");
                    String bossName = scanner.nextLine();
                    List<Company> bossCompanies = companyManagement.findCompaniesByBoss(bossName);
                    if (!bossCompanies.isEmpty()) {
                        bossCompanies.forEach(System.out::println);
                    } else {
                        System.out.println("找不到该老板创建的公司。");
                    }
                    break;
                case 7:
                    System.out.print("请输入老板名字: ");
                    String bossNameToCount = scanner.nextLine();
                    int companyCount = companyManagement.countCompaniesByBoss(bossNameToCount);
                    System.out.println(bossNameToCount + " 创建了 " + companyCount + " 家公司。");
                    break;
                case 8:
                    System.out.print("请输入年份: ");
                    int yearToFind = scanner.nextInt();
                    List<Company> companiesBeforeYear = companyManagement.findCompaniesBeforeYear(yearToFind);
                    if (!companiesBeforeYear.isEmpty()) {
                        companiesBeforeYear.forEach(System.out::println);
                    } else {
                        System.out.println("找不到指定年份以前创建的公司。");
                    }
                    break;
                case 9:
                    System.out.print("请输入关键字: ");
                    String keyword = scanner.nextLine();
                    List<Company> companiesWithKeyword = companyManagement.findCompaniesByNameContains(keyword);
                    if (!companiesWithKeyword.isEmpty()) {
                        companiesWithKeyword.forEach(System.out::println);
                    } else {
                        System.out.println("找不到包含 \"" + keyword + "\" 的公司。");
                    }
                    break;
                case 10:
                    System.out.print("请输入年份: ");
                    int yearToDelete = scanner.nextInt();
                    companyManagement.deleteCompaniesBeforeYear(yearToDelete);
                    break;
                case 11:
                    System.out.print("请选择排序方式 (1升序，0降序): ");
                    int sortOrder = scanner.nextInt();
                    boolean ascending = sortOrder == 1;
                    companyManagement.sortCompaniesByYear(ascending);
                    break;
                case 12:
                    Company latestCompany = companyManagement.getLatestCompany();
                    if (latestCompany != null) {
                        System.out.println("公司创立年份最晚的公司是: " + latestCompany);
                    } else {
                        System.out.println("没有公司数据。");
                    }
                    break;
                case 0:
                    System.out.println("感谢使用公司管理系统，再见！");
                    System.exit(1);
                    break;
                default:
                    System.out.println("无效的选项，请重新选择。");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}

