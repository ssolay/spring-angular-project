package com.spring.example.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.example.repository.entities.PlainTextHolder;
import com.spring.example.repository.repositories.PlainTextHolderRepository;
import com.spring.example.service.services.AboutService;

@Service
public class AboutServiceImpl implements AboutService {

    private static final String ABOUT_HOLDER_ID = "about";

    @Autowired
    private PlainTextHolderRepository plainTextHolderRepository;

    @Override
    public String getText() {
        return plainTextHolderRepository.findOne(ABOUT_HOLDER_ID).getText();
    }

    @Override
    public void updateText(String newText) {
        plainTextHolderRepository.save(new PlainTextHolder(ABOUT_HOLDER_ID, newText));
    }
}
