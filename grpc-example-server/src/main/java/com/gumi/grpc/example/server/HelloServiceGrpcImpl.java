package com.gumi.grpc.example.server;

import com.gumi.grpc.example.hello.model.HelloRequest;
import com.gumi.grpc.example.hello.model.HelloResponse;
import com.gumi.grpc.example.hello.service.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceGrpcImpl extends HelloServiceGrpc.HelloServiceImplBase {

    private final String GREETING_PATTERN = "Hello %s! My favourite city is %s";
    @Override
    public void hello(HelloRequest helloRequest, StreamObserver<HelloResponse> streamObserver){

        final var name = helloRequest.getName();
        final var city = helloRequest.getCity();
        final var greeting = String.format(GREETING_PATTERN, name, city);

        final var response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        streamObserver.onNext(response);
        streamObserver.onCompleted();

    }
}
