package com.example.student_service.controller;

import com.example.student_service.entity.Student;
import com.example.student_service.repository.StudentRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentRepo sRepo;

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return sRepo.findById(id).get();
    }
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        sRepo.save(student);
        return "added!";
    }

    @PutMapping("/editStudent/{id}")
    public String editStudent(@PathVariable("id") int id, @RequestBody Student student){
        Student s=new Student();
        s.setStudentName(student.getStudentName());
        s.setSchool(student.getSchool());
        s.setStandard(student.getStandard());
        sRepo.save(s);
        return "updated!";
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        sRepo.deleteById(id);
        return "deleted!";
    }



}
