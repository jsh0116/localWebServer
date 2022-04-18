package com.example.localWebServer.handler;

import com.example.localWebServer.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class PersonHandler {

    public Mono<ServerResponse> getResponseByName(ServerRequest request) {
        // get first query parameter
        Optional<String> query =  request.queryParam("name");

        if (query.isPresent()) {
            String name = query.get();
            Person person = new Person(name, "Hello " + name);
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(person);
        } else {
            return ServerResponse.badRequest().build();
        }
    }
}

