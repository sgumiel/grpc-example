package com.gumi.grpc.example.server;

import com.gumi.grpc.example.server.config.HelloServiceGrpcImplITConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
@SpringJUnitConfig(classes = { HelloServiceGrpcImplITConfig.class })
@DirtiesContext
@ActiveProfiles("it")
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
