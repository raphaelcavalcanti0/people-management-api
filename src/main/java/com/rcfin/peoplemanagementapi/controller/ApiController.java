package com.rcfin.peoplemanagementapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class ApiController {

    @GetMapping
    public String getStarted() {
        return "That's a start!";
    }

}
