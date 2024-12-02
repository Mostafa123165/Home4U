package com.service.common.service;

import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Random;

@Service
@Slf4j
@AllArgsConstructor
public class SendOptService {

    private final JavaMailSender mailSender;
    private TemplateEngine templateEngine;
    private final UserService userService;


    @Async
    @Transactional
    public void sendOtp(User user) {
        String otp = generateOTP() ;

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage) ;
            messageHelper.setTo(user.getEmail());
            messageHelper.setSubject("Home4U - OTP Verification");
            messageHelper.setText(buildContentMail(otp),true);
        };

        try {
            mailSender.send(messagePreparator);
            log.info("-->> otp sent successfully");
        }catch (MailException e) {
            throw new MailSendException(e.toString());
        }
        user.setOtp(otp);
        userService.update(user);
    }

    private String generateOTP() {
        Random random = new Random() ;
        int otp  = random.nextInt(10000,99999) ;
        return String.valueOf(otp) ;
    }

    private String buildContentMail(String otp) {
        Context context = new Context() ;
        context.setVariable("otp",otp);
        return templateEngine.process("OtpTemplate",context);
    }

}
