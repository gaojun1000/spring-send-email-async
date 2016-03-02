package com.thejavaside.async;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by jgao on 2/29/16.
 */
public class TestEmailService {

    @Test
    public void testSendingEmailAsync() throws Exception{

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application-context.xml");
        EmailService emailService =applicationContext.getBean(EmailService.class);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("support@stuff2share.com");
        simpleMailMessage.setTo("reply@stuff2share.com");
        simpleMailMessage.setSubject("Email Subject");
        simpleMailMessage.setText("Email Text");
        emailService.sendEmail(simpleMailMessage);
        //add the sleep to see the debug information
        Thread.sleep(1000);
    }
}
