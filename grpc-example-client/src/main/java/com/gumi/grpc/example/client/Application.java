package com.gumi.grpc.example.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gumi.grpc.example.hello.model.HelloRequest;
import com.gumi.grpc.example.hello.service.HelloServiceGrpc;

import net.devh.boot.grpc.client.inject.GrpcClient;

@SpringBootApplication
public class Application {

	@GrpcClient("helloService")
	private HelloServiceGrpc.HelloServiceBlockingStub helloService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {

		return args -> {
			final var helloRequest = HelloRequest.newBuilder()
							.setName("Sergio").setCity("Madrid").build();
			System.out.println(helloService.hello(helloRequest));
		};

	}
}