package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    @RequestMapping("/login")
    public String gotoLoginPage(@RequestParam String name) {
        System.out.printf("Request param is %s%n", name);//NOT RECOMMENDED FOR PROD CODE
        return "login";
    }
}
