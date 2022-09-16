package com.spring.example.repository.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.example.repository.entities.PlainTextHolder;

public interface PlainTextHolderRepository extends MongoRepository<PlainTextHolder, String> {}
