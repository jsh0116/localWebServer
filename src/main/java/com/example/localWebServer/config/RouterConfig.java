package com.example.localWebServer.config;

import com.example.localWebServer.handler.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class RouterConfig {

    /**
     * Web Request 를 받아 Response 를 돌려주는 메소드
     * @param personHandler 함수형 스타일의 웹 헨들러
     * @return RouterFunction 을 빌드한 결과물
     */
    @Bean
    public RouterFunction<ServerResponse> helloRouter(PersonHandler personHandler) {
        return RouterFunctions.route()
                .GET("/hello", personHandler::getResponseByName)
                .build();
    }

}
