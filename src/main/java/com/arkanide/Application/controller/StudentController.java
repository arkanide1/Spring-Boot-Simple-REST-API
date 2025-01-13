package com.arkanide.Application.controller;

import com.arkanide.Application.service.StudentService;
import com.arkanide.Application.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService service;
    @Autowired
    StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping("/")
    public List<Student> getStudents(){
        return service.getStudents();
    }
    @PostMapping("/")
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        service.updateStudent(id , name , email);
    }

}
