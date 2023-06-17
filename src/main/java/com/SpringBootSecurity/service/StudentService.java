package com.SpringBootSecurity.service;

import com.SpringBootSecurity.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Component
public class StudentService {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Kailash Yadav"),
            new Student(2, "Omkar Thapa"),
            new Student(3, "Suvam Sangam")
    );

    public List<Student> getStudents(){
        return STUDENTS;
    }

    public Student getById(Integer id){
        return STUDENTS.stream()
                .filter(student -> id.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("Student "+ id + "does not exists"));
    }

    public Student save(Student student){
        return student;
    }

    public Integer deleteStudent(Integer id){
        return id;
    }

    public Student update( Integer id, Student student){
        return student;
    }
}
