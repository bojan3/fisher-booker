package com.example.fisherbooker.service;

import javax.mail.MessagingException;

import com.example.fisherbooker.model.EmailContexts.EmailContext;

public interface EmailService {

    void sendMail(final EmailContext email) throws MessagingException;

}