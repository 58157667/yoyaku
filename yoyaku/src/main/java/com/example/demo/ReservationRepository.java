package com.example.demo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository
        extends JpaRepository<Reservation, Long> {

    boolean existsByReserveDateAndReserveTime(
            LocalDate reserveDate,
            String reserveTime
    );
}