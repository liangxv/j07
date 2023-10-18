package com.woniu.view;

import com.woniu.dao.impl.CustomerDaoImpl;
import com.woniu.pojo.Customer;

import java.sql.Date;
import java.util.Scanner;

public class CustomerView {

    static CustomerDaoImpl customer =new CustomerDaoImpl();

    private static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("------------- 客户管理 -------------");
        System.out.println("按1.查询所有客户");
        System.out.println("按2.根据id查询客户");
        System.out.println("按3.根据客户名称模糊查询");
        System.out.println("按4.根据电话号码模糊查询");
        System.out.println("按5.按照性别分类查询客户");
        System.out.println("按6.按照性别分组统计分别有多少客户");
        System.out.println("按7.新增客户");
        System.out.println("按8.根据id修改客户资料");
        System.out.println("按9.根据id删除客户");
        System.out.println("按10.返回上一层");
    }

    public static void operate() {
        while (true){
            menu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    customer.getAllCustomers().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println(customer.getCustomerById(id));
                    break;
                case 3:
                    System.out.println("输入客户名");
                    String name = scanner.next();
                    customer.getCustomersByName(name).forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("输入电话号码");
                    String phoneNumber = scanner.next();
                    customer.getCustomersByPhoneNumber(phoneNumber).forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("输入性别");
                    String gender = scanner.next();
                    customer.getCustomersByGender(gender).forEach(System.out::println);
                    break;
                case 6:
                    customer.getCustomerCountByGender().forEach(System.out::println);
                    break;
                case 7:
                    Customer customers = new Customer();
                    System.out.println("输入姓名");
                    customers.setName(scanner.next());
                    System.out.println("输入号码");
                    customers.setTel(scanner.next());
                    System.out.println("输入邮箱");
                    customers.setEmail(scanner.next());
                    System.out.println("输入性别");
                    customers.setGender(scanner.next());
                    System.out.println("输入生日");
                    customers.setBirthday(Date.valueOf(scanner.next()));
                    System.out.println("输入服务人员id");
                    customers.setEmpId(scanner.nextInt());
                    if (customer.addCustomer(customers)>0) {
                        System.out.println("添加成功");
                    }
                    break;
                case 8:
                    customers = new Customer();
                    System.out.println("输入客户id");
                    customers.setId(scanner.nextInt());
                    System.out.println("输入姓名");
                    customers.setName(scanner.next());
                    System.out.println("输入号码");
                    customers.setTel(scanner.next());
                    System.out.println("输入邮箱");
                    customers.setEmail(scanner.next());
                    System.out.println("输入性别");
                    customers.setGender(scanner.next());
                    System.out.println("输入生日");
                    customers.setBirthday(Date.valueOf(scanner.next()));
                    System.out.println("输入服务人员id");
                    customers.setEmpId(scanner.nextInt());
                    if (customer.updateCustomerById(customers)>0) {
                        System.out.println("修改成功");
                    }
                    break;
                case 9:
                    System.out.println("输入客户id");
                    id= scanner.nextInt();
                    if (customer.deleteCustomerById(id)>0) {
                        System.out.println("删除成功");
                    }
                    break;
                case 10:
                    return;
                default:
                    System.out.println("输入有误！");
            }
        }
    }
}
