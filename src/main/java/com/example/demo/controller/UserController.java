package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PreAuthorize("hasRole('ADMIN')")
// or @Secured({"ADMIN"})
// or @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String createUser(ModelMap model, @RequestParam("name") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping
    public ResponseEntity<User> getUserName() {
        return new ResponseEntity<>(userService.getName(), HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<String> getName() {
        return new ResponseEntity<>(userService.getUserName(), HttpStatus.OK);
    }
}
