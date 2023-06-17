package com.SpringBootSecurity.service;

import com.SpringBootSecurity.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@Component
public class StudentService {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Kailash Yadav"),
            new Student(2, "Omkar Thapa"),
            new Student(3, "Suvam Sangam")
    );

    public List<Student> getStudents(){
        log.info("All Student Fetched.");
        return STUDENTS;
    }

    public Student getById(Integer id){
        return STUDENTS.stream()
                .filter(student -> id.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("Student "+ id + "does not exists"));
    }

    public Student save(Student student){
        log.info("Student saved");
        return student;
    }

    public Integer deleteStudent(Integer id){
        log.info("Student deleted of id " + id);
        return id;
    }

    public Student update( Integer id, Student student){
        log.info("student updated of id "+ id);
        return student;
    }
}
