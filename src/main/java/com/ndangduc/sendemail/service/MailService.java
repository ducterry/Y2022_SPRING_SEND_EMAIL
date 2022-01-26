package com.ndangduc.sendemail.service;

import com.ndangduc.sendemail.model.DataMailDTO;

import javax.mail.MessagingException;

public interface MailService {
    void sendHtmlMail(DataMailDTO dataMail, String templateName) throws MessagingException;
}
