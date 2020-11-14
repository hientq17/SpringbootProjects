package edu.fpt.controllers;

import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;
import edu.fpt.models.Photo;
import edu.fpt.models.FileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

@Controller
@RequestMapping("/")
public class UploadController {

    String errorMessage = "";

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(@ModelAttribute FileUpload fileUpload, BindingResult result, ModelMap model) throws IOException {
//        PhotoUploadValidator validator = new PhotoUploadValidator();
//        validator.validate(fileUpload, result);

        if(fileUpload.getTitle().isEmpty()){
            errorMessage = "Title is empty";
            System.out.println(errorMessage);
            return "redirect:/upload_form";
        }

        //validation
        if (fileUpload.getFile() == null || fileUpload.getFile().isEmpty()) {
            if (!fileUpload.validSignature()) {
                errorMessage = "Signature invalid";
                System.out.println(errorMessage);
                return "redirect:/upload_form";
            }
        }
        if(fileUpload.getFile().getSize()/(1048576)>2){
            errorMessage = "File upload over 2MB";
            System.out.println(errorMessage);
            return "redirect:/upload_form";
        }


        Map uploadResult = null;
        if (fileUpload.getFile() != null && !fileUpload.getFile().isEmpty()) {
            File file = new File("src/main/resources/"+fileUpload.getFile().getOriginalFilename());
            //convert multipart file o file
            try (OutputStream os = new FileOutputStream(file)) {
                os.write(fileUpload.getFile().getBytes());
            }
            uploadResult = Singleton.getCloudinary().uploader().upload(file,
                    ObjectUtils.asMap("resource_type", "auto","use_filename","true","folder","test"));
            // "use_filename","true" => keep original filename + and add id to the end
            // "unique_filename","false" => keep original filename and dont add anything
            // "folder","test" => upload to folder test
            file.delete();
            fileUpload.setPublicId((String) uploadResult.get("public_id"));
            Object version = uploadResult.get("version");
            if (version instanceof Integer) {
                fileUpload.setVersion(new Long((Integer) version));    
            } else {
                fileUpload.setVersion((Long) version);
            }
            fileUpload.setSignature((String) uploadResult.get("signature"));
            fileUpload.setFormat((String) uploadResult.get("format"));
            fileUpload.setResourceType((String) uploadResult.get("resource_type"));
        }

        if (result.hasErrors()){
            model.addAttribute("fileUpload", fileUpload);
            return "upload_form";
        } else {
            Photo photo = new Photo();
            photo.setTitle(fileUpload.getTitle());
            photo.setUpload(fileUpload);
            model.addAttribute("upload", uploadResult);
            model.addAttribute("photo", photo);
            return "upload";
        }
    }

    @RequestMapping(value = "/upload_form", method = RequestMethod.GET)
    public String uploadFileForm(ModelMap model) {
        model.addAttribute("fileUpload", new FileUpload());
        if(errorMessage.length()>0) {
            model.addAttribute("errorMessage", errorMessage);
        }
        return "upload_form";
    }

}
