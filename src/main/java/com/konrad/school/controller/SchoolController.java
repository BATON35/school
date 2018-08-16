package com.konrad.school.controller;

import com.konrad.school.iservice.ISchoolService;
import com.konrad.school.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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

    @GetMapping("school/add/view")
    public String addSchoolViev(Model model) {
        model.addAttribute("school", new School());
        return "addSchoolForm";
    }

    @PostMapping("school/add")
    public  String addSchool(@Valid @ModelAttribute("school") School school, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "addSchoolForm";
        }
        schoolService.save(school);
        return "redirect:/";
    }
}
