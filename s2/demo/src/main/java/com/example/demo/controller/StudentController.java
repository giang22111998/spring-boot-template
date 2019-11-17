package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
@RequestMapping("/student")
public class StudentController {

    List<Student> studentList = new CopyOnWriteArrayList<>();

    @GetMapping("/add")
    public String addTodo(Model model) {
        model.addAttribute("student", new Student());
        return "student/addStudent";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute Student student) {
        studentList.add(student);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String studentList(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        if (studentList.size() > 0) {
            if (limit != null && limit > studentList.size()) {
                limit = studentList.size();
            }
            model.addAttribute("studentList", limit != null ? studentList.subList(0, limit) : studentList);
        }
        return "student/listStudent";
    }
}
