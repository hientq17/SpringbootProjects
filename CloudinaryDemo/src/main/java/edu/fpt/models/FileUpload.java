package edu.fpt.models;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload extends StoredFile {

    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "mrend",
            "api_key", "935971468737829",
            "api_secret", "BqEH96l0EZ5rM7bh1BxRexNcscY"));

    public FileUpload(){
        SingletonManager manager = new SingletonManager();
        manager.setCloudinary(cloudinary);
        manager.init();
    }

    private String title;

    private MultipartFile file;

    public String getUrl() {
        if (version != null && format != null && publicId != null) {
            return cloudinary.url()
                    .resourceType(resourceType)
                    .type(type)
                    .format(format)
                    .version(version)
                    .generate(publicId);
        } else return null;
    }

    public String getThumbnailUrl() {
        if (version != null && format != null && publicId != null) {
            return cloudinary.url().format(format)
                    .resourceType(resourceType)
                    .type(type)
                    .version(version).transformation(new Transformation().width(150).height(150).crop("fit"))
                    .generate(publicId);
        } else return null;
    }

    public String getComputedSignature() {
        return getComputedSignature(cloudinary);
    }

    public boolean validSignature() {
        return getComputedSignature().equals(signature);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
