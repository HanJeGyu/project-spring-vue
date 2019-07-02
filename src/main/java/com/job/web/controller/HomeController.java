package com.job.web.controller;

import com.job.web.service.JobseekerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController
 */
@Controller
public class HomeController {

    @Autowired JobseekerService jobseekerService; // 자동으로 연결? -> 스레드 
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}