package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {

        boolean isValidUser = username.equalsIgnoreCase("jack");
        boolean isValidPass = password.equalsIgnoreCase("Passw0rd");

        return isValidUser && isValidPass;
    }
}
