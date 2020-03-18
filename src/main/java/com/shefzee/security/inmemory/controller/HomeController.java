package com.shefzee.security.inmemory.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipal;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/test1")
    @PreAuthorize("hasAnyAuthority('READ','WRITE')")
    public String test1(){

        return "Test1, Read, Write Access";

    }


    @GetMapping("/test2")
    @PreAuthorize("hasAuthority('WRITE')")
    public String test2(){

        return "Test2, Write Access";

    }

    @GetMapping("/test3")
    @PreAuthorize("hasRole('ROLE_USER_L3')")
    public String test3(){

        return "Test3, Role User_L3 Access";

    }

    @GetMapping("/test4")
    public String test4(){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return "No Security";

    }


}
