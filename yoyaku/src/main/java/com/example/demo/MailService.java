//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class  {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    public void sendReservationMail(Reservation reservation) {
//
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        // 公司邮箱
//        message.setTo("hedan7965@gmail.com");
//
//        // 标题
//        message.setSubject("新预约通知");
//
//        // 邮件内容
//        String body =
//                "收到新的预约。\n\n" +
//                "姓名: " + reservation.getName() + "\n" +
//                "邮箱: " + reservation.getEmail() + "\n" +
//                "电话: " + reservation.getPhone() + "\n" +
//                "预约日期: " + reservation.getReserveDate() + "\n" +
//                "预约时间: " + reservation.getReserveTime() + "\n" +
//                "服务项目: " + reservation.getService();
//
//        message.setText(body);
//
//        mailSender.send(message);
//    }
//}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendReservationMail(Reservation reservation)
            throws Exception {

        MimeMessage message =
                mailSender.createMimeMessage();

        MimeMessageHelper helper =
                new MimeMessageHelper(
                        message,
                        true,
                        "UTF-8"
                );

        
        
        // 必须是真实 Gmail
        helper.setFrom("hedan7965@gmail.com");

        // 收件人
        helper.setTo("hedan7965@gmail.com");

        // 标题
        helper.setSubject("新しい予約");

        // 内容
        helper.setText(
                "名前: " + reservation.getName() + "\n" +
                "電話: " + reservation.getPhone() + "\n" +
                "メール: " + reservation.getEmail() + "\n" +
                "日付: " + reservation.getReserveDate() + "\n" +
                "時間: " + reservation.getReserveTime()+ "\n" +
                "サービス: " + reservation.getService()
        );

        mailSender.send(message);
    }
}
