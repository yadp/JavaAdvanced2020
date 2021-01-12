package com.example.demo.controller;

import com.example.demo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private List<Student> students=new ArrayList<>();

    @GetMapping("/student")
    public String studentForm(Model model){
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/student")
    public String postStudent(@ModelAttribute Student student, Model model){
        students.add(student);
        model.addAttribute("student",student);
        model.addAttribute("students",students);
        return "result";
    }
}
