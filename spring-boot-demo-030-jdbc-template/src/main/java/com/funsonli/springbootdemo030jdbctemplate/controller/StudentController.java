package com.funsonli.springbootdemo030jdbctemplate.controller;

import com.funsonli.springbootdemo030jdbctemplate.entity.Student;
import com.funsonli.springbootdemo030jdbctemplate.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Student Controller
 *
 * @author Funson
 * @date 2019/10/12
 */

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping({"", "/", "index"})
    public String index() {
        return studentService.index().toString();
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student modelAttribute, BindingResult result) {
        if (result.hasErrors()) {
            return "binding error";
        }

        int res = studentService.save(modelAttribute);
        return String.valueOf(res);
    }
}
