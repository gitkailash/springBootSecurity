package com.SpringBootSecurity.controller;

import com.SpringBootSecurity.entity.Student;
import com.SpringBootSecurity.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private final StudentService studentService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('student:write')")
    public ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.ok(studentService.save(student));
    }

    @DeleteMapping("{studentId}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public ResponseEntity<Integer> deleteStudent(@PathVariable("studentId") Integer id){
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

    @PutMapping("{studentId}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public ResponseEntity<Student> update(@PathVariable("studentId") Integer studentId, Student student){
        return ResponseEntity.ok(studentService.update(studentId, student));
    }

}
