package edu.fpt.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "answer", schema = "quizlet", catalog = "")
public class AnswerEntity {
    private int answerId;
    private String answerContent;
    private Boolean answerCorrect;
    private int questionId;
    private QuestionEntity questionByQuestionId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answerId", nullable = false)
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    @Basic
    @Column(name = "answerContent", nullable = true, length = 500)
    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    @Basic
    @Column(name = "answerCorrect", nullable = true)
    public Boolean getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(Boolean answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    @Basic
    @Column(name = "questionId", nullable = false)
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerEntity that = (AnswerEntity) o;
        return answerId == that.answerId &&
                questionId == that.questionId &&
                Objects.equals(answerContent, that.answerContent) &&
                Objects.equals(answerCorrect, that.answerCorrect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, answerContent, answerCorrect, questionId);
    }

    @ManyToOne
    @JoinColumn(name = "questionId", referencedColumnName = "questionId", nullable = false, insertable = false, updatable = false)
    public QuestionEntity getQuestionByQuestionId() {
        return questionByQuestionId;
    }

    public void setQuestionByQuestionId(QuestionEntity questionByQuestionId) {
        this.questionByQuestionId = questionByQuestionId;
    }
}
