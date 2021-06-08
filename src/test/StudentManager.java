package test;

import domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        l:
        while (true) {
            System.out.println("----------欢迎来到学生信息管理系统----------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");

            String choice = sc.next();

            switch (choice) {
                case "1":
                    //System.out.println("ADD");
                    addStudent(list);
                    break;
                case "2":
                    //System.out.println("delete");
                    deleteStudent(list);
                    break;
                case "3":
                    //System.out.println("alter");
                    updateStudent(list);
                    break;
                case "4":
                    //System.out.println("see");
                    queryStudent(list);
                    break;
                case "5":
                    System.out.println("感谢你的使用");
                    break l;
                default:
                    System.out.println("error");
                    break;
            }
        }

    }

    public static void updateStudent(ArrayList<Student> list) {
        System.out.println("请输入要修改的学生学号：");

        Scanner sc = new Scanner(System.in);
        String altId = sc.next();

        int index = getIndex(list, altId);

        if(index == -1){
            System.out.println("查无信息，请重新输入：");
        }else{
            System.out.println("请输入姓名：");
            String name = sc.next();
            System.out.println("请输入年龄：");
            int age = sc.nextInt();
            System.out.println("请输入生日：");
            String birthday = sc.next();
            //封装为新的学生对象
            Student stu = new Student(altId,name,age,birthday);
            //调用集合的set方法，完成修改
            list.set(index,stu);
            System.out.println("修改成功");
        }

    }

    public static void deleteStudent(ArrayList<Student> list) {
        //1. 给出提示信息
        System.out.println("请输入你要删除的学生学号：");
        //2. 键盘接受信息
        Scanner sc = new Scanner(System.in);
        String delid = sc.next();
        //3. 调用getIndex方法判断学号是否存在
        int index = getIndex(list, delid);
        //4. 存在则删除；不存在则给出提示信息
        if(index == -1){
            System.out.println("查无信息，请重新输入：");
        }else {
            list.remove(index);
            System.out.println("删除成功！");
        }
    }

    public static void queryStudent(ArrayList<Student> list) {
        //1. 判断集合中是否有数据，如果不存在直接给出提示
        if (list.size() == 0) {
            System.out.println("无信息，请添加后重试");
            return;
        }
        //2. 存在，显示表头信息
        System.out.println("学号\t姓名\t年龄\t生日");
        //3. 遍历集合，获取每一个学生对象信息打印
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getSid() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getBirthday());
        }

    }

    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String sid;

        while(true){
            System.out.println("请输入学号：");
             sid = sc.next();

            int index = getIndex(list, sid);

            if(index == -1){
                //sid不存在，即可以进行录入
                break;
            }

        }
        System.out.println("请输入姓名：");
        String name = sc.next();
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        System.out.println("请输入生日：");
        String birthday = sc.next();

        Student stu = new Student(sid, name, age, birthday);

        list.add(stu);

        System.out.println("添加成功");
    }

    //查找这个学号在集合中的位置
    public static int getIndex(ArrayList<Student> list, String sid){
        //1. 首先假设在集合中不存在
        int index = -1;
        //2. 遍历集合进行查找
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            String id = stu.getSid();
            if(id.equals(sid)){
                index = i;
            }

        }
        //3. 如果找不到，则返回-1，反之则返回索引值
        return index;
    }

}
