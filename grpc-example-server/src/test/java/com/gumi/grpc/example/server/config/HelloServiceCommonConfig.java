package com.gumi.grpc.example.server.config;

import com.gumi.grpc.example.server.HelloServiceGrpcImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloServiceCommonConfig {

    @Bean
    HelloServiceGrpcImpl helloServiceGrpc() {
        return new HelloServiceGrpcImpl();
    }
}
