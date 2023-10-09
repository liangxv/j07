package com.woniuxy.p4;

public class Teacher {
    private String name; //名字
    private int age; //年龄
    public String subject; //科目
    public Teacher() {
    }
    //私有的构造方法
    private Teacher(String name) {
        this.name = name;
    }
    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    //私有方法，计算工作年限
    private int calculateYearsOfExperience() {
        return age - 22;
    }
    //公有方法：获取教师的信息
    public String getTeacherInfo() {
        return "姓名: " + name + ", 年龄: " + age + ", 科目: " + subject;
    }
    //上课
    public void teach() {
        System.out.println("老师在上课： " + subject);
    }
    //私有方法：备课
    private String prepareLesson(String topic) {
        return "准备上课：" + topic;
    }
    //开会
    public void attendMeeting(int durationInHours) {
        System.out.println("开了 " + durationInHours + " 个小时会");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                '}';
    }
}
