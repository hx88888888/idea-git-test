package com.itheima.test;

import com.itheima.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> list = new ArrayList<>();
        lo:
        while (true) {
            System.out.println("------欢迎来到学生管理系统------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入您的选择：");

            String choice = sc.next();

            switch (choice) {
                case "1":
                    //System.out.println("添加学生");
                    addStudent(list);
                    break;
                case "2":
                    //System.out.println("删除学生");
                    deleteStudent(list);
                    break;

                case "3":
                    //System.out.println("修改学生");
                    updateStudent(list);
                    break;

                case "4":
                    //System.out.println("查看学生");
                    queryStudent(list);
                    break;

                case "5":
                    System.out.println("感谢您的使用");
                    break lo;

                default:
                    System.out.println("您的输入有误，请重新输入：");
                    break;

            }
        }

    }

    public static void updateStudent(ArrayList<Student> list) {
        System.out.println("请输入要修改的学生学号：");
        Scanner sc = new Scanner(System.in);
        String updateSid = sc.next();
        int index = getIndex(list, updateSid);
        if(index == -1){
            System.out.println("查无此人，请重新输入！");
        }else{
            System.out.println("请输入新的学生姓名：");
            String name = sc.next();
            System.out.println("请输入新的学生年龄：");
            int age = sc.nextInt();
            System.out.println("请输入新的学生生日：");
            String birthday = sc.next();
            Student stu = new Student(updateSid,name, age, birthday);
            list.set(index,stu);
            System.out.println("修改成功");
        }
    }

    public static void deleteStudent(ArrayList<Student> list) {
        System.out.println("请输入要删除的学生学号：");
        Scanner sc = new Scanner(System.in);
        String deleteSid = sc.next();
        int index = getIndex(list, deleteSid);
        if(index == -1){
            System.out.println("查无此人，请重新输入！");
        }else{
            list.remove(index);
            System.out.println("删除成功");
        }


    }

    public static void queryStudent(ArrayList<Student> list) {
        if(list.size() == 0){
            System.out.println("无信息，请确认添加后执行...");
            return;
        }

        System.out.println("学号\t\t姓名\t\t\t年龄\t\t生日");

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId()+"\t\t"+stu.getName()+"\t\t"+stu.getAge()+"\t\t"+stu.getBirthday());
        }

    }


    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String sid;
        while (true) {
            System.out.println("请输入学生学号：");
            sid = sc.next();
            int index = getIndex(list, sid);
            if(index == -1){
                break;
            }else{
                System.out.print("学号重复,");
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        System.out.println("请输入学生生日：");
        String birthday = sc.next();

        Student stu = new Student(sid, name, age, birthday);

        list.add(stu);

        System.out.println("添加成功");


    }

    public static int getIndex(ArrayList<Student> list, String sid) {
        int index = -1;

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (sid .equals(stu.getId())) {
                index = i;
            }
        }
        return index;
    }


}
