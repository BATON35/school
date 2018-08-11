package com.konrad.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "fancy-login";
    }
    @GetMapping("/leader")
    public String showLeadersPage() {
        return "leaders";
    }
    @GetMapping("/access-denied")
    public String DemoedLoginPage() {
        return "fancy-login";
    }
}
