package edu.fpt.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "question", schema = "quizlet", catalog = "")
public class QuestionEntity {
    private int questionId;
    private String questionContent;
    private int examId;
    private Collection<AnswerEntity> answersByQuestionId;
    private ExamEntity examByExamId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionId", nullable = false)
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "questionContent", nullable = true, length = 1000)
    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    @Basic
    @Column(name = "examId", nullable = false)
    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity that = (QuestionEntity) o;
        return questionId == that.questionId &&
                examId == that.examId &&
                Objects.equals(questionContent, that.questionContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, questionContent, examId);
    }

    @OneToMany(mappedBy = "questionByQuestionId")
    public Collection<AnswerEntity> getAnswersByQuestionId() {
        return answersByQuestionId;
    }

    public void setAnswersByQuestionId(Collection<AnswerEntity> answersByQuestionId) {
        this.answersByQuestionId = answersByQuestionId;
    }

    @ManyToOne
    @JoinColumn(name = "examId", referencedColumnName = "examId", nullable = false, insertable = false, updatable = false)
    public ExamEntity getExamByExamId() {
        return examByExamId;
    }

    public void setExamByExamId(ExamEntity examByExamId) {
        this.examByExamId = examByExamId;
    }

}
