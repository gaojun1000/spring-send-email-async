package com.thejavaside.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

/**
 * Created by jgao on 2/29/16.
 */
@Service
public class EmailService {
    @Autowired
    private ExecutorService executorService;

    @Autowired
    private MailSender mailSender;

    public void sendEmail (SimpleMailMessage smm) {
        executorService.submit(new EmailTask(smm));
    }

    private final class EmailTask implements Runnable {
        private SimpleMailMessage smm;

        public EmailTask(SimpleMailMessage smm) {
            this.smm = smm;
        }

        public void run() {
            System.out.println("sending email");
            mailSender.send(smm);
        }
    }

}
