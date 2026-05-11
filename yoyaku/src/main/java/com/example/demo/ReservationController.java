package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin("*")
public class ReservationController {

    @Autowired
    private ReservationRepository repository;
    @Autowired
    private MailService mailService;
    @PostMapping
    public String createReservation(
            @RequestBody Reservation reservation
    ) throws Exception {

        boolean exists =
                repository.existsByReserveDateAndReserveTime(
                        reservation.getReserveDate(),
                        reservation.getReserveTime()
                );

        if (exists) {
            return "この時間は既に予約されました。";
        }

        repository.save(reservation);
		
        try {
			mailService.sendReservationMail(reservation);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        return "予約成功しました。";
    }
}
