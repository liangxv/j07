package com.woniu.view;

import com.woniu.dao.CustomerDao;
import com.woniu.dao.EmployeeDao;
import com.woniu.dao.impl.CustomerDaoImpl;
import com.woniu.dao.impl.EmployeeDaoImpl;
import com.woniu.dao.impl.ProductDaoImpl;
import com.woniu.pojo.Customer;
import com.woniu.pojo.Employee;
import com.woniu.pojo.Product;
import com.woniu.utils.LoginStatus;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    static CustomerDao customerDao =new CustomerDaoImpl();
    static EmployeeDao employeeDao = new EmployeeDaoImpl();

    static ProductDaoImpl productDao =new ProductDaoImpl();

    private static final Scanner scanner = new Scanner(System.in);
    private static void menu() {
        System.out.println("------------- 员工管理 -------------");
        System.out.println("按1.新增员工");
        System.out.println("按2.查询所有员工");
        System.out.println("按3.根据id查询员工");
        System.out.println("按4.查询自己的客户[报表]");
        System.out.println("按5.统计自己的客户[报表]");
        System.out.println("按6.选择自己的客户购买产品");
        System.out.println("按7.查询自己的客户购买了哪些的产品");
        System.out.println("按10.返回上一层");
        System.out.println("请输入您的选择：");
    }

    public static void operate() {
        while (true) {
            //显示菜单
            menu();
            //选择
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    //新增员工
                    addEmployee();
                    break;
                case 4:
                    //查询自己的客户
                    findByEmployeeId();
                    break;
                case 5:
                    //查询自己客户数量
                    countByEmployeeId();
                    break;
                case 6:
                    //选择自己的客户购买产品
                    buyProduct();
                    break;
                case 7:
                    //查询自己的客户购买了哪些产品
                    findProductsByCustomerId();
                    break;
                case 10:
                    return;
            }
        }
    }

    /**
     * 查询自己的客户购买了哪些产品
     */
    private static void findProductsByCustomerId() {
        //1.找到自己的客户是哪些并显示
        findByEmployeeId();
        System.out.println("请选择要查询哪个客户(输入客户的ID)");
        int customerId = scanner.nextInt();
        //2.调用数据层查询
        List<Product> products = productDao.findProductsByCustomerId(customerId);
        System.out.println("该客户购买的产品如下：");
        products.forEach(System.out::println);
    }

    //选择自己的客户购买产品
    private static void buyProduct() {
        //1.找到自己的客户是哪些并显示
        findByEmployeeId();
        System.out.println("请选择哪个客户购买(输入客户的ID)");
        int customerId = scanner.nextInt();

        //2.显示所有的产品
        List<Product> products = productDao.findAll();
        System.out.println("产品列表如下：");
        products.forEach(System.out::println);

        //3.客户购买产品
        System.out.println("请选择购买的产品ID：");
        int productId = scanner.nextInt();
        int row = customerDao.buy(customerId, productId);
        if (row > 0) {
            System.out.println("购买产品成功");
        } else {
            System.out.println("购买失败");
        }
    }

    /**
     * 查询自己客户数量
     */
    private static void countByEmployeeId() {
        //获取当前已经登录的用户
        Employee employee = LoginStatus.current;
        //调用DAO查询
        long count = customerDao.count(employee.getId());
        System.out.println("您客户数量是：" + count + "个");
    }

    /**
     * 查询自己的客户
     */
    private static void findByEmployeeId() {
        //获取当前已经登录的用户
        Employee employee = LoginStatus.current;
        //调用DAO查询
        List<Customer> customers = customerDao.findByEmployeeId(employee.getId());
        System.out.println("您的客户如下：");
        customers.forEach(System.out::println);
    }

    /**
     * 添加员工
     */
    private static void addEmployee() {
        System.out.println("请输入用户名：");
        String userName = scanner.next();
        System.out.println("请输入登录名：");
        String loginName = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        //封装成一个对象
        Employee employee = new Employee(null, userName, loginName, password);
        //调用DAO层添加员工
        int row = employeeDao.addEmployee(employee);
        System.out.println("成功添加了" + row + "个员工");
    }

}
