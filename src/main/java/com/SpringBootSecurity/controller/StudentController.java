package com.SpringBootSecurity.controller;

import com.SpringBootSecurity.entity.Student;
import com.SpringBootSecurity.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping({"/", ""})
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentsById(@PathVariable("studentId") Integer studentId){
        return ResponseEntity.ok().body(studentService.getById(studentId));
    }
}
