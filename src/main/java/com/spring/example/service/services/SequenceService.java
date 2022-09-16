package com.spring.example.service.services;

public interface SequenceService {

    /**
     * Return next ID for given sequence.
     * @param seqName sequence name
     * @return next ID
     */
    Long getNextSequence(String seqName);
}
