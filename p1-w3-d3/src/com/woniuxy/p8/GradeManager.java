package com.woniuxy.p8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradeManager {
    private Map<String, Double> gradeTable;
    private Scanner scanner;

    public GradeManager() {
        gradeTable = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void addGrade(String studentName, double grade) {
        gradeTable.put(studentName, grade);
        System.out.println(studentName + " 的成绩已添加: " + grade);
    }

    public void viewGrade(String studentName) {
        if (gradeTable.containsKey(studentName)) {
            double grade = gradeTable.get(studentName);
            System.out.println(studentName + " 的成绩是: " + grade);
        } else {
            System.out.println("找不到学生 " + studentName + " 的成绩");
        }
    }

    public void updateGrade(String studentName, double newGrade) {
        if (gradeTable.containsKey(studentName)) {
            gradeTable.put(studentName, newGrade);
            System.out.println(studentName + " 的成绩已更新为: " + newGrade);
        } else {
            System.out.println("找不到学生 " + studentName + " 的成绩");
        }
    }

    public void removeGrade(String studentName) {
        if (gradeTable.containsKey(studentName)) {
            double removedGrade = gradeTable.remove(studentName);
            System.out.println(studentName + " 的成绩 " + removedGrade + " 已删除");
        } else {
            System.out.println("找不到学生 " + studentName + " 的成绩");
        }
    }

    public void calculateAverageGrade() {
        double totalGrade = 0;
        int studentCount = gradeTable.size();

        if (studentCount == 0) {
            System.out.println("成绩表为空，无法计算平均成绩。");
        } else {
            for (double grade : gradeTable.values()) {
                totalGrade += grade;
            }
            double averageGrade = totalGrade / studentCount;
            System.out.println("所有学生的平均成绩是: " + averageGrade);
        }
    }

    public static void main(String[] args) {
        GradeManager gradeManager = new GradeManager();

        // 添加学生成绩
        gradeManager.addGrade("Alice", 95.5);
        gradeManager.addGrade("Bob", 88.0);
        gradeManager.addGrade("Charlie", 92.5);

        System.out.println();

        // 查看学生成绩
        gradeManager.viewGrade("Alice");

        // 更新学生成绩
        System.out.print("请输入要更新成绩的学生姓名: ");
        String studentToUpdate = gradeManager.scanner.nextLine();
        if (gradeManager.gradeTable.containsKey(studentToUpdate)) {
            System.out.print("请输入新的成绩: ");
            double newGrade = gradeManager.scanner.nextDouble();
            gradeManager.updateGrade(studentToUpdate, newGrade);

        } else {
            System.out.println("找不到学生 " + studentToUpdate + " 的成绩");
        }

        // 删除学生成绩
        System.out.print("请输入要删除成绩的学生姓名: ");
        String studentToRemove = gradeManager.scanner.next();
        gradeManager.removeGrade(studentToRemove);

        // 计算平均成绩
        gradeManager.calculateAverageGrade();

    }
}

