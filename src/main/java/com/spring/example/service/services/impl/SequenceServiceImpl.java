package com.spring.example.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.example.repository.repositories.SequenceRepository;
import com.spring.example.service.services.SequenceService;

@Service
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private SequenceRepository sequenceRepository;

    @Override
    public Long getNextSequence(String seqName) {
        return sequenceRepository.getNextSequence(seqName);
    }
}
