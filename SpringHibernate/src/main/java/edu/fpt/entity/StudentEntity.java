package edu.fpt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties
@Table(name = "student", schema = "student", catalog = "")
public class StudentEntity {
    private int stdId;
    private Integer classId;
    private Integer majorId;
    private Integer stdAge;
    private String stdName;
    private ClassnameEntity classnameByClassId;
    private MajorEntity majorByMajorId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stdId", nullable = false)
    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    @Basic
    @Column(name = "classId", nullable = true)
    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "majorId", nullable = true)
    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    @Basic
    @Column(name = "stdAge", nullable = true)
    public Integer getStdAge() {
        return stdAge;
    }

    public void setStdAge(Integer stdAge) {
        this.stdAge = stdAge;
    }

    @Basic
    @Column(name = "stdName", nullable = true, length = 50)
    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return stdId == that.stdId &&
                Objects.equals(classId, that.classId) &&
                Objects.equals(majorId, that.majorId) &&
                Objects.equals(stdAge, that.stdAge) &&
                Objects.equals(stdName, that.stdName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stdId, classId, majorId, stdAge, stdName);
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "classId", referencedColumnName = "classId", insertable=false, updatable=false)
    public ClassnameEntity getClassnameByClassId() {
        return classnameByClassId;
    }

    public void setClassnameByClassId(ClassnameEntity classnameByClassId) {
        this.classnameByClassId = classnameByClassId;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "majorId", referencedColumnName = "majorId", insertable=false, updatable=false)
    public MajorEntity getMajorByMajorId() {
        return majorByMajorId;
    }

    public void setMajorByMajorId(MajorEntity majorByMajorId) {
        this.majorByMajorId = majorByMajorId;
    }
}
