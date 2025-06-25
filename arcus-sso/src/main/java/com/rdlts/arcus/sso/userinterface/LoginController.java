package com.rdlts.arcus.sso.userinterface;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/arcus-sso/login")
@RestController
public class LoginController {

    @PostMapping("/")
    public String login() {
        return "Login page";
    }
}
