package edu.fpt.spring.entities;

public class Student {
    String stdId, stdClass, name, major;

    public Student() {
    }

    public Student(String stdId, String stdClass, String name, String major) {
        this.stdId = stdId;
        this.stdClass = stdClass;
        this.name = name;
        this.major = major;
    }

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getStdClass() {
        return stdClass;
    }

    public void setStdClass(String stdClass) {
        this.stdClass = stdClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
