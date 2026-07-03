package com.Rupesh.SafarNama.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    public void sendEnquiryEmail(String name, String email, String phone,String subject , String message ) {
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom("info@safarnamaevents.in");
        mail.setTo("info@safarnamaevents.in");
        mail.setText("Name : " + name +
                        "\nEmail : " + email +
                        "\nPhone : " + phone +
                        "\nSubject :" + subject +
                        "\n\nMessage :\n" + message);
        mailSender.send(mail);
    }
}
