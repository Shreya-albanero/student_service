package com.example.student_service.controller;

import com.example.student_service.entity.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
@RestController
public class NotesConsumer {
    @Autowired
    RestTemplate restTemplate;
    String url = "http://localhost:8989";

    @RequestMapping("/studentGetNotes")
    public String studentGetNotes(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        url+="/getNotes/113";
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
    }
    @RequestMapping("/studentPostNotes")
    public String studentAddNotes(@RequestBody Notes notes) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Notes> entity = new HttpEntity<>(notes, headers);
        url+="/addNotes";
        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
    }
    @PutMapping("/studentEditNotes")
    public Notes studentEditNotes(@RequestBody Notes notes){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Notes> entity = new HttpEntity<>(notes,headers);
        url+="/updateNotes/112";
        return restTemplate.exchange(url, HttpMethod.PUT, entity, Notes.class).getBody();
    }
    @DeleteMapping("/studentDeleteNotes/{id}")
    public String studentDeleteNotes(@PathVariable("id") int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Notes> entity = new HttpEntity<Notes>(headers);
        url+="/delete/";
        return restTemplate.exchange(url+id, HttpMethod.DELETE, entity, String.class).getBody();
    }
}
