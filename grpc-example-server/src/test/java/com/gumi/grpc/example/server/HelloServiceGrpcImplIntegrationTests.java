package com.gumi.grpc.example.server;

import com.gumi.grpc.example.hello.model.HelloRequest;
import com.gumi.grpc.example.hello.model.HelloResponse;
import com.gumi.grpc.example.hello.service.HelloServiceGrpc;
import com.gumi.grpc.example.server.config.HelloServiceGrpcImplITConfig;
import io.grpc.internal.testing.StreamRecorder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
@SpringJUnitConfig(classes = { HelloServiceGrpcImplITConfig.class })
@DirtiesContext
@ActiveProfiles("it")
public class HelloServiceGrpcImplIntegrationTests {

    @GrpcClient("inProcess")
    private HelloServiceGrpc.HelloServiceBlockingStub helloService;

    @Test
    @DirtiesContext
    void testHello() throws Exception {
        HelloRequest request = HelloRequest.newBuilder()
                .setName("Sergio")
                .setCity("Madrid")
                .build();
        StreamRecorder<HelloResponse> responseObserver = StreamRecorder.create();
        final var helloResponse = helloService.hello(request);
        Assert.assertEquals(HelloResponse.newBuilder()
                .setGreeting("Hello Sergio! My favourite city is Madrid")
                .build(), helloResponse);
    }

}
