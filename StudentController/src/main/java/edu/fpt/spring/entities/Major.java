package edu.fpt.spring.entities;

public class Major {
    private String majorName;
    private int majorId;

    public Major() {
    }

    public Major(int majorId, String majorName) {
        this.majorName = majorName;
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }
}
