package com.gumi.grpc.example.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(HelloServiceCommonConfig.class)
public class HelloServiceGrpcImplUTConfig {

}
