package com.ndangduc.sendemail.controller;

import com.ndangduc.sendemail.model.ClientSdi;
import com.ndangduc.sendemail.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email/")
public class EmailController {
    private final ClientService clientService;

    public EmailController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "create")
    public ResponseEntity<Boolean> create(@RequestBody ClientSdi request) {
        return ResponseEntity.ok(clientService.create(request));
    }
}
