package com.example.demo.service;

import com.example.demo.annotation.*;
import org.springframework.stereotype.*;

@Service
public class StudentServiceImpl implements StudentService {

    @MyAnnotation
    @Override
    public String getName() {
        return "NAME";
    }
}
