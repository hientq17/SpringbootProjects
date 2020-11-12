package edu.fpt.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "exam", schema = "quizlet", catalog = "")
public class ExamEntity {
    private int examId;
    private String examName;
    private int examSemester;
    private int majorId;
    private MajorEntity majorByMajorId;
    private Collection<QuestionEntity> questionsByExamId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examId", nullable = false)
    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    @Basic
    @Column(name = "examName", nullable = true, length = 100)
    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    @Basic
    @Column(name = "examSemester", nullable = false)
    public int getExamSemester() {
        return examSemester;
    }

    public void setExamSemester(int examSemester) {
        this.examSemester = examSemester;
    }

    @Basic
    @Column(name = "majorId", nullable = false)
    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamEntity that = (ExamEntity) o;
        return examId == that.examId &&
                examSemester == that.examSemester &&
                majorId == that.majorId &&
                Objects.equals(examName, that.examName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examId, examName, examSemester, majorId);
    }

    @ManyToOne
    @JoinColumn(name = "majorId", referencedColumnName = "majorId", nullable = false, insertable = false, updatable = false)
    public MajorEntity getMajorByMajorId() {
        return majorByMajorId;
    }

    public void setMajorByMajorId(MajorEntity majorByMajorId) {
        this.majorByMajorId = majorByMajorId;
    }

    @OneToMany(mappedBy = "examByExamId")
    public Collection<QuestionEntity> getQuestionsByExamId() {
        return questionsByExamId;
    }

    public void setQuestionsByExamId(Collection<QuestionEntity> questionsByExamId) {
        this.questionsByExamId = questionsByExamId;
    }
}
