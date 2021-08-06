package com.gumi.grpc.example.server;

import com.gumi.grpc.example.hello.model.HelloRequest;
import com.gumi.grpc.example.hello.model.HelloResponse;
import com.gumi.grpc.example.hello.service.HelloServiceGrpc;
import com.gumi.grpc.example.server.config.HelloServiceGrpcImplUTConfig;
import io.grpc.internal.testing.StreamRecorder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@SpringJUnitConfig(classes = { HelloServiceGrpcImplUTConfig.class })
@ActiveProfiles("ut")
public class HelloServiceGrpcImplUnitTests {

    @Autowired
    private HelloServiceGrpc.HelloServiceImplBase helloService;

    @Test
    void testHello() throws Exception {
        HelloRequest request = HelloRequest.newBuilder()
                .setName("Sergio")
                .setCity("Madrid")
                .build();
        StreamRecorder<HelloResponse> responseObserver = StreamRecorder.create();
        helloService.hello(request, responseObserver);
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            Assert.fail("The call did not terminate in time");
        }
        Assert.assertNull(responseObserver.getError());
        List<HelloResponse> results = responseObserver.getValues();
        Assert.assertEquals(1, results.size());
        HelloResponse response = results.get(0);
        Assert.assertEquals(HelloResponse.newBuilder()
                .setGreeting("Hello Sergio! My favourite city is Madrid")
                .build(), response);
    }
}
