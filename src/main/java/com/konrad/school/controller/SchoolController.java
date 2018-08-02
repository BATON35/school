package com.konrad.school.controller;

import com.konrad.school.iservice.ISchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SchoolController {
    private ISchoolService schoolService;

    @Autowired
    SchoolController(ISchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/")
    public String listSchools(Model model) {
        model.addAttribute("schools", schoolService.findAll());
        return "schoolsList";
    }

    @PostMapping("school/delete")
    public String deleteSchool(@RequestParam int toJestToId) {
        schoolService.delete(toJestToId);
        return "redirect:/";
    }
}
