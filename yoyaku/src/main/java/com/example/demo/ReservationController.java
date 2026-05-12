package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin("*")
public class ReservationController {

    @Autowired
    private ReservationRepository repository;

    @PostMapping
    public ResponseEntity<String> createReservation(
            @RequestBody Reservation reservation
    ) {

        boolean exists =
                repository.existsByReserveDateAndReserveTime(
                        reservation.getReserveDate(),
                        reservation.getReserveTime()
                );

        // 时间冲突
        if (exists) {

            return ResponseEntity
                    .badRequest()
                    .body("この時間は既に予約されています。");

        }

        // 保存数据库
        repository.save(reservation);

        // 成功
        return ResponseEntity
                .ok("予約成功しました。");
    }
}
