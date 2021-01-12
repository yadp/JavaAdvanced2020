package com.example.demo.controller;


import com.example.demo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(required = false, defaultValue = "World") String name,
                           Model model){
        name = name + "Inside Java";

        Student student=new Student(name);
        model.addAttribute("student",student);
        List<String> list = new ArrayList();
        list.add("Test");

        model.addAttribute("list",list);
        return "greeting";
    }
}
