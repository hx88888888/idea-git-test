package com.itheima.domain;

public class Student {
    private String id;
    private String name;
    private int age;
    private String birthday;

    public Student() {
    }

    public Student(String id, String name, int age, String birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    //我是dev01中新增的代码123456789
    public int getAge() {
        return age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
