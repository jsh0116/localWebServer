package com.example.localWebServer.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Optional;

@Component
public class PersonHandler {
    WebClient webClient = WebClient.create("http://localhost:8761");
    public Mono<ServerResponse> getResponseByName(ServerRequest request) {
        // get first query parameter
        Optional<String> query =  request.queryParam("name");

        if (query.isPresent()) {
            String name = query.get();
//            Person person = new Person(name, "Hello " + name);
            Mono<HashMap> result = webClient.get().uri("/job?name=" + name).retrieve().bodyToMono(HashMap.class);
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromProducer(result, HashMap.class));
        } else {
            return ServerResponse.badRequest().build();
        }
    }
}

