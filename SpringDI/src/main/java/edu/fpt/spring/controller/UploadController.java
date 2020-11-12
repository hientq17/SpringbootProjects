package edu.fpt.spring.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

@Controller
public class UploadController {

    @Autowired
    ServletContext servletContext;

    @GetMapping("/upload")
    public ModelAndView upload(){
        ModelAndView mav = new ModelAndView("uploadFile");
        return mav;
    }

    @PostMapping("/upload")
    public ModelAndView upload(@RequestParam("image") MultipartFile image){
        ApplicationContext context;
        ModelAndView mav = new ModelAndView("uploadFile");
        if(image.isEmpty()){
            mav.addObject("message","Please upload an image!");
        } else{
            try{
                Path path = Paths.get("images/");
                try{
                    InputStream inputStream = image.getInputStream();
                    Files.copy(inputStream,path.resolve(image.getOriginalFilename()),
                            StandardCopyOption.REPLACE_EXISTING);
                    //Convert MultipartFile to File
                    File file = new File(image.getOriginalFilename());
                    file.createNewFile();
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(image.getBytes());
                    //Convert File to Base64 String
                    FileInputStream fileInputStreamReader = new FileInputStream(file);
                    byte[] bytes = new byte[(int)file.length()];
                    fileInputStreamReader.read(bytes);
                    String encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
                    System.out.println(encodedfile);
                }catch (Exception ex){
                    ex.printStackTrace();
                    mav.addObject("message","Error: "+ex.getMessage());
                }
                mav.addObject("name",image.getOriginalFilename());
                mav.addObject("type",image.getContentType());
                mav.addObject("size",image.getSize());
            }catch (Exception e){
                System.out.println("ERROR: "+e);
                mav.addObject("message","Save file failure");
            }
        }
        return mav;
    }

}
