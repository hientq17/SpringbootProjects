package edu.fpt.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "major", schema = "quizlet", catalog = "")
public class MajorEntity {
    private int majorId;
    private String majorName;
    private Collection<ExamEntity> examsByMajorId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "majorId", nullable = false)
    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    @Basic
    @Column(name = "majorName", nullable = true, length = 100)
    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MajorEntity that = (MajorEntity) o;
        return majorId == that.majorId &&
                Objects.equals(majorName, that.majorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(majorId, majorName);
    }

    @OneToMany(mappedBy = "majorByMajorId")
    public Collection<ExamEntity> getExamsByMajorId() {
        return examsByMajorId;
    }

    public void setExamsByMajorId(Collection<ExamEntity> examsByMajorId) {
        this.examsByMajorId = examsByMajorId;
    }
}
