package edu.fpt.lib;

import edu.fpt.models.FileUpload;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class FileUploadValidator implements Validator {
    public boolean supports(Class clazz) {
        return FileUpload.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "title", "title.empty");
        FileUpload pu = (FileUpload) obj;
        if (pu.getFile() == null || pu.getFile().isEmpty()) {
            if (!pu.validSignature()) {
                e.rejectValue("signature", "signature.mismatch");
            }
        }
        if(pu.getFile().getSize()/(1048576)>2){
            System.out.println("Over size");
            e.rejectValue("size", "file.size");
        }
    }

}
