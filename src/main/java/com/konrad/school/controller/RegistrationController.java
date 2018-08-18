package com.konrad.school.controller;

import com.konrad.school.iservice.IParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/register")
public class RegistrationController {

    private IParentService parentService;

    @Autowired
    RegistrationController (IParentService parentService) {
        this.parentService = parentService;
    }
}
