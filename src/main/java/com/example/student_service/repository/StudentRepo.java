package com.example.student_service.repository;

import com.example.student_service.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
public interface StudentRepo extends MongoRepository<Student, Integer> {
}
