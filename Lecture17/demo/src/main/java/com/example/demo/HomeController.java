package com.example.demo;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Profile("dev")
public class HomeController {


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "503", description = "NotOk")
    })

    @GetMapping("/health")
    public @ResponseBody String test(@RequestParam String test){
        int a=5;
        a++;
        a++;
        //Select *
        return "Hello Yavor";
    }

    @GetMapping("/test")
    public @ResponseBody String test2(){
        return "";
    }
}
