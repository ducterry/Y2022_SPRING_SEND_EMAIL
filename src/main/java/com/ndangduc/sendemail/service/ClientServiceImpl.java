package com.ndangduc.sendemail.service;

import com.ndangduc.sendemail.constants.Const;
import com.ndangduc.sendemail.model.ClientSdi;
import com.ndangduc.sendemail.model.DataMailDTO;
import com.ndangduc.sendemail.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private MailService mailService;

    @Override
    public Boolean create(ClientSdi request) {
        try {
            DataMailDTO dataMail = DataMailDTO.builder()
                    .to(request.getEmail())
                    .subject(Const.SEND_MAIL_SUBJECT)
                    .props(Map.ofEntries(
                            Map.entry("name", request.getName()),
                            Map.entry("username", request.getUsername()),
                            Map.entry("password", DataUtils.generateTempPwd(8))))
                    .build();

            this.mailService.sendHtmlMail(dataMail, Const.TEMPLATE_FILE_NAME);
            return true;
        } catch (MessagingException exp) {
            exp.printStackTrace();
        }
        return false;
    }
}