package com.example.student_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection="Notes")
public class Notes {
    @Id
    private int id;
    String topic;
    String description;

}