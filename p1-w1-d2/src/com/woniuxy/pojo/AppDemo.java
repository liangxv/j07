package com.woniuxy.pojo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppDemo {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        double weight = getInput("请输入你的体重（千克）:", scanner);
        double height = getInput("请输入你的身高（米）:", scanner);

        double BMI = weight/(height*height);

        if (BMI>=32){
            System.out.println("");
        } else if (BMI>=28 && BMI <32) {
            System.out.println("非常肥胖");
        } else if (BMI>=24 && BMI < 28) {
            System.out.println("肥胖");
        } else if (BMI>=18.5 && BMI < 24) {
            System.out.println("正常");
        }else {
            System.out.println("过轻");
        }
    }

    private static double getInput(String prompt, Scanner scanner) {
        double input = 0.0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                input = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("请输入有效的数值！");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        return input;
    }
}
