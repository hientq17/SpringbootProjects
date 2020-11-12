package edu.fpt.controller;

import edu.fpt.entity.AnswerEntity;
import edu.fpt.entity.Counter;
import edu.fpt.entity.QuestionEntity;
import edu.fpt.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/test")
    public ModelAndView test(){
        ModelAndView mav = new ModelAndView("test");
        List<QuestionEntity> questionEntityList = questionRepository.findAll();
        List<List<AnswerEntity>> answerList = new ArrayList<>();
        for (QuestionEntity q: questionEntityList ) {
            List<AnswerEntity> answerEntityList = (List<AnswerEntity>) q.getAnswersByQuestionId();
            answerList.add(answerEntityList);
        }
        Counter counter = new Counter(-1);
        mav.addObject("questionList",questionEntityList);
        mav.addObject("answerList",answerList);
        mav.addObject("counter",counter);
        return mav;
    }

    @GetMapping("/learning")
    public ModelAndView learning(){
        ModelAndView mav = new ModelAndView("learning");
        List<QuestionEntity> questionEntityList = questionRepository.findAll();
        List<List<AnswerEntity>> answerList = new ArrayList<>();
        for (QuestionEntity q: questionEntityList ) {
            List<AnswerEntity> answerEntityList = (List<AnswerEntity>) q.getAnswersByQuestionId();
            answerList.add(answerEntityList);
        }
        Counter counter = new Counter(-1);
        mav.addObject("questionList",questionEntityList);
        mav.addObject("answerList",answerList);
        mav.addObject("counter",counter);
        return mav;
    }
}
