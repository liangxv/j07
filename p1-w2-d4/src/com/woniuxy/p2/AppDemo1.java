package com.woniuxy.p2;

import java.util.HashSet;
import java.util.Objects;


public class AppDemo1 {
    public static void main(String[] args) {
        HashSet<Student> studentSet =new HashSet<>();
        studentSet.add(new Student(1,"张三",88));
        studentSet.add(new Student(1,"李四",88));
        studentSet.add(new Student(1,"王五",88));
        System.out.println(studentSet);
        studentSet.add(new Student(1,"张三",88));
        System.out.println(studentSet);
    }
}
 class Student {
    private int id;
    private String name;
    private double grades;

     public Student() {
     }

     public Student(int id, String name, double grades) {
         this.id = id;
         this.name = name;
         this.grades = grades;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public double getGrades() {
         return grades;
     }

     public void setGrades(double grades) {
         this.grades = grades;
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         Student student = (Student) o;

         if (id != student.id) return false;
         if (Double.compare(student.grades, grades) != 0) return false;
         return Objects.equals(name, student.name);
     }

     @Override
     public int hashCode() {
         int result;
         long temp;
         result = id;
         result = 31 * result + (name != null ? name.hashCode() : 0);
         temp = Double.doubleToLongBits(grades);
         result = 31 * result + (int) (temp ^ (temp >>> 32));
         return result;
     }

     @Override
     public String toString() {
         return "Student{" +
                 "id=" + id +
                 ", name='" + name + '\'' +
                 ", grades=" + grades +
                 '}';
     }
 }
