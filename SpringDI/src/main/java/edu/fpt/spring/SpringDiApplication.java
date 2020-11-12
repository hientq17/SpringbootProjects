package edu.fpt.spring;

import edu.fpt.spring.model.Company;
import edu.fpt.spring.model.Mailer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDiApplication.class, args);
        Company comp = (Company) context.getBean("fpt");
        System.out.println(comp.getLogo()+": "+comp.getName());
        ((Mailer)context.getBean("mailer")).send("Hien dep zai");
    }

    @Bean(name = "fpt")
    public Company getCompany(){
         Company comp = new Company();
         comp.setName("FPT University");
         comp.setLogo("FPTU");
         return comp;
    }
}
