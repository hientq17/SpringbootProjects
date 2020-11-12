package edu.fpt.spring.controllers;

import edu.fpt.spring.entities.Major;
import edu.fpt.spring.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @ModelAttribute("majors")
    List<Major> getMajors() {
        List<Major> list = new ArrayList<>();
        list.add(new Major(1, "Java"));
        list.add(new Major(2, "PHP"));
        list.add(new Major(3, "C++"));
        return list;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newStudent(ModelMap model) {
        model.addAttribute("std", new Student());
        return "students/new";
    }

//    @RequestMapping(value = "/new", method = RequestMethod.POST)
//    public String detailStudent(@RequestParam("stdId") String stdId, @RequestParam("stdClass") String stdClass,
//           @RequestParam("name") String name,@RequestParam("major") String major, ModelMap model) {
//        switch(major){
//            case "1":
//                major = "Java";
//                break;
//            case "2":
//                major = "PHP";
//                break;
//            case "3":
//                major = "C++";
//                break;
//        }
//        Student std = new Student(stdId, stdClass, name, major);
//        model.addAttribute("std", std);
//        return "students/detail";
//    }

//    @RequestMapping(value = "/new", method = RequestMethod.POST)
//    public String detailStudent(Student std, ModelMap model) {
//        switch(std.getMajor()){
//            case "1":
//                std.setMajor("Java");
//                break;
//            case "2":
//                std.setMajor("PHP");
//                break;
//            case "3":
//                std.setMajor("C++");
//                break;
//        }
//        model.addAttribute("std", std);
//        return "students/detail";
//    }

    @GetMapping("/detail")
    //@RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String listStudents(ModelMap model) {
        Student std = new Student();
        std.setName("Hien");
        std.setStdId("DE140248");
        std.setStdClass("SE1401");
        std.setMajor("Java");
        model.addAttribute("std", std);
        return "students/detail";
    }

    @PostMapping(value = "/detail", params = "btnEdit")
    //@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "btnEdit")
    public String editStudent() {
        return "students/edit";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST, params = "btnDelete")
    public String deleteStudents() {
        return "students/delete";
    }
}
