package edu.fpt.api;

import edu.fpt.entity.MajorEntity;
import edu.fpt.entity.StudentEntity;
import edu.fpt.service.MajorService;
import edu.fpt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    StudentService studentService;

    @Autowired
    MajorService majorService;

    @GetMapping("/listStudent")
    public List<StudentEntity> listStudent(){
        List<StudentEntity> stdList = studentService.findAll();
        return stdList;
    }

    @PostMapping("/major")
    public MajorEntity major(@RequestParam int id){
        return majorService.findById(id);
    }

    @GetMapping("/listMajor")
    public List<MajorEntity> listMajor(){
        List<MajorEntity> majorList = majorService.findAll();
        return majorList;
    }

    @PostMapping("/insertStudent")
    public StudentEntity insertStudent(@RequestBody StudentEntity std){
        return studentService.save(std);
    }
}
