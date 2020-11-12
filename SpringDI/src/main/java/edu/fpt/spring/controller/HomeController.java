package edu.fpt.spring.controller;

import edu.fpt.spring.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;

@Controller
public class HomeController {

    @Autowired @Qualifier("fpt")
    Company comp;

    @Autowired
    ServletContext context;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("comp",comp);
        System.out.println("Path: "+ context.getRealPath("/"));
        return mav;
    }
}
