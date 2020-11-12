package edu.fpt.controller;

import edu.fpt.entity.UserEntity;
import edu.fpt.google.GooglePojo;
import edu.fpt.google.GoogleUtils;
import edu.fpt.repository.UserRepository;
import edu.fpt.service.UserService;
import org.apache.http.client.ClientProtocolException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private GoogleUtils googleUtils;

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("/test")
    public String test() {
        Session session = entityManager.unwrap(Session.class);
        String hql = " from edu.fpt.entity.UserEntity";
        Query query = session.createQuery(hql);
        List<UserEntity> userList = query.list();
        System.out.println("Test: "+userList.size());
        System.out.println("EntityManager: "+entityManager);
        return "test";
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @RequestMapping("/login-google")
    public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
        String code = request.getParameter("code");

        if (code == null || code.isEmpty()) {
            return "redirect:/login?google=error";
        }
        String accessToken = googleUtils.getToken(code);

        GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
        UserDetails userDetail = googleUtils.buildUser(googlePojo);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                userDetail.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/index";
    }

}
