package domain;

public class Student {
    private String sid;
    private String name;
    private int age;
    private String birthday;


    public Student(String sid, String name, int age, String birthday) {
        this.sid = sid;
        this.name = name;
        this.birthday = birthday;
        this.age = age;
    }

    public Student() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
