package edu.fpt.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "classname", schema = "student", catalog = "")
public class ClassnameEntity {
    private int classId;
    private String className;
    private Collection<StudentEntity> studentsByClassId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classId", nullable = false)
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "className", nullable = true, length = 50)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassnameEntity that = (ClassnameEntity) o;
        return classId == that.classId &&
                Objects.equals(className, that.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, className);
    }

    @OneToMany(mappedBy = "classnameByClassId")
    public Collection<StudentEntity> getStudentsByClassId() {
        return studentsByClassId;
    }

    public void setStudentsByClassId(Collection<StudentEntity> studentsByClassId) {
        this.studentsByClassId = studentsByClassId;
    }
}
