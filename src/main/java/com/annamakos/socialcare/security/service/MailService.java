package com.annamakos.socialcare.security.service;

import com.annamakos.socialcare.api.dto.VisitDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String myEmail;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendVisitConfirmation(VisitDTO visit) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(visit.getUser().getEmail());
        mail.setFrom(myEmail);
        mail.setSubject("Potwierdzenie wizyty");

        StringBuilder text = new StringBuilder();
        text.append("Witaj ")
                .append(visit.getUser().getName())
                .append(" ")
                .append(visit.getUser().getSurname())
                .append(",\n\npotwierdzamy Twoją wizytę u ")
                .append(visit.getOfficial().getName())
                .append(" ")
                .append(visit.getOfficial().getSurname())
                .append("\nWizyta odbędzie się dnia ")
                .append(visit.getVisitDate().toString().substring(0, 10))
                .append(" o godzinie ")
                .append(visit.getVisitDate().toString().substring(11, 16))
                .append(".\nw placówce: ")
                .append(visit.getOfficial().getInstitution().getName())
                .append("\n")
                .append(visit.getOfficial().getInstitution().getAddress())
                .append("\n\nZapraszamy\nOśrodek Opieki Społecznej");
        String message = text.toString();
        mail.setText(message);

        javaMailSender.send(mail);
    }
}
