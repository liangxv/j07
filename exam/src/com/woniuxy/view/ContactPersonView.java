package com.woniuxy.view;

import com.woniuxy.dao.ContactPersonDao;
import com.woniuxy.dao.impl.ContactPersonDaoImpl;
import com.woniuxy.pojo.ContactPerson;

import java.sql.Date;
import java.util.Scanner;

public class ContactPersonView {
    private static final Scanner scanner = new Scanner(System.in);

    private static ContactPersonDao contactPersonDao = new ContactPersonDaoImpl();

    private static void menu() {
        System.out.println("------------- 联系人管理 -------------");
        System.out.println("按1.查询所有联系人");
        System.out.println("按2.通过id查询一个联系人");
        System.out.println("按3.添加联系人");
        System.out.println("按4.修改联系人");
        System.out.println("按5.统计所有男生和女生分别有多少个");
        System.out.println("按6.查询生日范围内的联系人");
        System.out.println("按7.查询某个城市的联系人");
        System.out.println("按8.按生日的升序或降序排序(1 升序 2 降序)");
        System.out.println("按9.分页查询()输入敌机页和每页大小");
        System.out.println("按10.返回上一级");
        System.out.println("请输入您的选择：");
    }

    public static void operate() {
        //选择
        while (true){
            menu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    getAllContactPerson();
                    break;
                case 2:
                    getContactPersonById();
                    break;
                case 3:
                    addContactPerson();
                    break;
                case 4:
                    UpdateContactPerson();
                    break;
                case 5:
                    groupStatisticsGender();
                    break;
                case 6:
                    getBirthdayRange();
                    break;
                case 7:
                    getContactPersonByCity();
                    break;
                case 8:
                    sortByBirthday();
                    break;
                case 9:
                    pagingQuery();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("输入有误！");
            }
        }
    }

    private static void pagingQuery() {
        System.out.println("输入页数");
        int page = scanner.nextInt();
        System.out.println("输入页大小");
        int size = scanner.nextInt();
        contactPersonDao.pagingQuery(page, size).forEach(System.out::println);
    }

    private static void sortByBirthday() {
        System.out.println("输入1 升序 2 降序");
        int sort = scanner.nextInt();
        contactPersonDao.sortByBirthday(sort).forEach(System.out::println);
    }

    private static void getContactPersonByCity() {
        System.out.println("输入城市");
        String city = scanner.next();
        contactPersonDao.getContactPersonByCity(city).forEach(System.out::println);
    }

    private static void getBirthdayRange() {
        System.out.println("输入开始的生日");
        String start = scanner.next();
        System.out.println("输入结束的生日");
        String end = scanner.next();
        contactPersonDao.getBirthdayRange(start, end).forEach(System.out::println);
    }

    private static void groupStatisticsGender() {
        contactPersonDao.groupStatisticsGender().forEach(System.out::println);
    }

    private static void UpdateContactPerson() {
        System.out.println("输入id");
        int id = scanner.nextInt();
        System.out.println("输入名字");
        String name = scanner.next();
        System.out.println("输入性别");
        String gender = scanner.next();
        System.out.println("输入生日");
        String birthday = scanner.next();
        System.out.println("输入手机号码");
        String telephone = scanner.next();
        System.out.println("输入城市");
        String city = scanner.next();
        ContactPerson contactPerson = new ContactPerson(id, name, gender, Date.valueOf(birthday), telephone, city);
        if (contactPersonDao.UpdateContactPerson(contactPerson) > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    private static void addContactPerson() {
        System.out.println("输入名字");
        String name = scanner.next();
        System.out.println("输入性别");
        String gender = scanner.next();
        System.out.println("输入生日");
        String birthday = scanner.next();
        System.out.println("输入手机号码");
        String telephone = scanner.next();
        System.out.println("输入城市");
        String city = scanner.next();
        ContactPerson contactPerson = new ContactPerson(null, name, gender, Date.valueOf(birthday), telephone, city);
        if (contactPersonDao.addContactPerson(contactPerson) > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    private static void getContactPersonById() {
        System.out.println("输入id:");
        int id = scanner.nextInt();
        System.out.println(contactPersonDao.getContactPersonById(id));
    }

    private static void getAllContactPerson() {
        contactPersonDao.getAllContactPerson().forEach(System.out::println);
    }
}
