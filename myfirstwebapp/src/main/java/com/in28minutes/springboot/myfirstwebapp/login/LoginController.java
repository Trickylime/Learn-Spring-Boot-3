package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

//    private Logger logger = LoggerFactory.getLogger(getClass());

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotoLoginPage() {//@RequestParam String name, ModelMap model

        return "login";
//        logger.debug("Request param is {}", name);
//        logger.info("I want this printed at info level");
//        logger.warn("I want this printed at warn level");
//        System.out.printf("Request param is %s%n", name);//NOT RECOMMENDED FOR PROD CODE
//        model.put("name", name);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password,
                                  ModelMap model) {

        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);

            return "welcome";
        }

        model.put("errorMessage", "Invalid Credentials! Please try again.");
        return "login";
    }
}
