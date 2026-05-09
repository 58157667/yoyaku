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

    @PostMapping
    public String createReservation(
            @RequestBody Reservation reservation
    ) {

        boolean exists =
                repository.existsByReserveDateAndReserveTime(
                        reservation.getReserveDate(),
                        reservation.getReserveTime()
                );

        if (exists) {
            return "この時間は既に予約しました。";
        }

        repository.save(reservation);

        return "予約成功しました。";
    }
}