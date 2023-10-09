package com.woniuxy.p5;

import java.util.Scanner;

public class EmployeeManagementSystem {
    static EmployeeDao employeeDao = BeanFactory.createObject("text");
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            menu();
            System.out.print("请输入选项：");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    findAllEmployees();
                    break;
                case 2:
                    findEmployeesBySalaryRange();
                    break;
                case 3:
                    groupEmployeesByDepartment();
                    break;
                case 4:
                    addEmployee();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    updateEmployee();
                    break;
                case 7:
                    sortCompaniesBySalary();
                    break;
                case 0:
                    System.out.println("谢谢使用，再见！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("无效选项，请重新输入！");
                    break;
            }
            System.out.println();
        } while (choice != 0);
        scanner.close();
    }

    private static void sortCompaniesBySalary() {
        System.out.print("请选择排序方式 (1升序，0降序): ");
        int sortOrder = scanner.nextInt();
        boolean ascending = sortOrder == 1;
        employeeDao.sortCompaniesBySalary(ascending).forEach(System.out::println);
    }

    private static void updateEmployee() {
        System.out.print("请输入员工的ID: ");
        int id = scanner.nextInt();
        System.out.print("请输入员工的姓名: ");
        String name = scanner.next();
        System.out.print("请输入员工的工资: ");
        double salary = scanner.nextDouble();
        System.out.print("请输入员工的部门: ");
        String depart = scanner.next();
        Employee employee = employeeDao.createEmployee(id, name, salary, depart);
        employeeDao.updateEmployee(id, employee);
        System.out.println("员工信息已更新！");
    }

    private static void deleteEmployee() {
        System.out.print("请输入要删除的员工的ID: ");
        int id = scanner.nextInt();
        employeeDao.delEmployee(id);
        System.out.println("员工已删除！");
    }

    private static void addEmployee() {
        System.out.print("请输入员工的姓名: ");
        String name = scanner.next();
        System.out.print("请输入员工的工资: ");
        double salary = scanner.nextInt();
        System.out.print("请输入员工的部门: ");
        String depart = scanner.next();
        employeeDao.addEmployee(employeeDao.createEmployee(0, name, salary, depart));
        System.out.println("员工已添加！");
    }

    private static void groupEmployeesByDepartment() {
        System.out.println("部门统计信息:");
        employeeDao.groupByDepartment().forEach((depart, count) -> System.out.println(depart + ": " + count + "人"));
    }

    private static void findEmployeesBySalaryRange() {
        System.out.print("请输入开始工资: ");
        int startSalary = scanner.nextInt();
        System.out.print("请输入结束工资: ");
        int endSalary = scanner.nextInt();
        employeeDao.findBySalary(startSalary, endSalary).forEach(System.out::println);
    }

    private static void findAllEmployees() {
        System.out.println("所有员工信息:");
        employeeDao.findAll().forEach(System.out::println);
    }

    private static void menu() {
        System.out.println("---------- 员工管理系统 ----------");
        System.out.println("1. 查询所有员工信息");
        System.out.println("8. 通过编号查询一位员工");
        System.out.println("4. 新增一个员工信息");
        System.out.println("6. 根据员工编号修改一个员工信息");
        System.out.println("5. 根据员工编号删除一个员工信息");
        System.out.println("2. 查询指定工资范围内的员工信息");
        System.out.println("3. 按部门进行分组，统计每个部门有多少人");
        System.out.println("7. 按工资进行排序：1升序 2降序");
        System.out.println("0. 退出");
    }
}
