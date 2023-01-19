package com.example.student_service.controller;

import com.example.student_service.config.WebFluxConfig;
import com.example.student_service.entity.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class WebClientConsumer {
    @Autowired
    WebFluxConfig webFluxConfig;

    String url="http://localhost:8989";

    @GetMapping("/webGetNotes/{id}")
    public Mono<Notes> webGetNotes(@PathVariable("id") int id) {

        url+="/getNotes/";

        return webFluxConfig.webfluxClient().get()
                .uri(url+id)
                .retrieve()
                .bodyToMono(Notes.class);
    }

    @PostMapping("/webAddNotes")
    public Mono<Notes> webAddNotes(@RequestBody Notes notes) {
        url+="/addNotes";
        return webFluxConfig.webfluxClient().post()
                .uri(url)
                .body(Mono.just(notes), Notes.class)
                .retrieve()
                .bodyToMono(Notes.class);
    }
    @PutMapping("/webupdateNotes/{id}")
    public  Mono<Notes> webupdateNotes(@PathVariable("id") int id, @RequestBody Notes notes) {
        url+="/updateNotes/";
        return webFluxConfig.webfluxClient().put()
                .uri(url+id)
                .body(Mono.just(notes), Notes.class)
                .retrieve()
                .bodyToMono(Notes.class);
    }
    @DeleteMapping("/webDeleteNotes/{id}")
    public String webDeleteNotes(@PathVariable("id") int id){
        url+="/delete/";
        String responsebody= webFluxConfig.webfluxClient().delete()
                .uri(url+id)
                .retrieve()
                .toEntity(String.class).block().getBody();
        return responsebody;
    }
}
