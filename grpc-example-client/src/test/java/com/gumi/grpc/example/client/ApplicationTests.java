package com.gumi.grpc.example.client;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.gumi.grpc.example.client.config.server.db.DefaultPostgresContainer;
import com.gumi.grpc.example.client.config.server.grpc.GrpcServerMockITConfig;


@ContextConfiguration(initializers = { DefaultPostgresContainer.Initializer.class })
@SpringBootTest
@SpringJUnitConfig(classes = { GrpcServerMockITConfig.class })
@DirtiesContext
@ActiveProfiles("it")
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
