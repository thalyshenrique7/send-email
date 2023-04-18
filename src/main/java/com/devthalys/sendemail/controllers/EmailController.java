package com.devthalys.sendemail.controllers;

import com.devthalys.sendemail.dtos.EmailDto;
import com.devthalys.sendemail.models.EmailModel;
import com.devthalys.sendemail.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    @ResponseStatus(CREATED)
    public EmailModel sendingEmail(@RequestBody @Valid EmailDto dto){
        EmailModel email = new EmailModel();
        BeanUtils.copyProperties(dto, email);
        emailService.sendEmail(email);
        return email;
    }
}
