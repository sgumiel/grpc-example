package com.gumi.grpc.example.client.config.server.grpc.mock;

import com.gumi.grpc.example.hello.model.HelloRequest;
import com.gumi.grpc.example.hello.model.HelloResponse;
import com.gumi.grpc.example.hello.service.HelloServiceGrpc.HelloServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcServerMockHelloService extends HelloServiceImplBase{
	
	@Override
	public void hello(HelloRequest helloRequest, StreamObserver<HelloResponse> streamObserver) {
		
		final var name = helloRequest.getName();
        final var city = helloRequest.getCity();

        final var response = HelloResponse.newBuilder()
                .setGreeting(name+city)
                .build();

        streamObserver.onNext(response);
        streamObserver.onCompleted();

	}

}


