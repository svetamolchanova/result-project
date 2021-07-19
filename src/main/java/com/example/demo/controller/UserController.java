package com.example.demo.controller;

import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @PreAuthorize("hasRole('ADMIN')")
// or @Secured({"ADMIN"})
// or @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String createUser(ModelMap model, @RequestParam("name") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
}
