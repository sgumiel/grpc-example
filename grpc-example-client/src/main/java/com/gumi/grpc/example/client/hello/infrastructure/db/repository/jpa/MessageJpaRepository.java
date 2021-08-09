package com.gumi.grpc.example.client.hello.infrastructure.db.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.gumi.grpc.example.client.hello.infrastructure.db.model.MessageEntity;

public interface MessageJpaRepository extends CrudRepository<MessageEntity, Long>{

}