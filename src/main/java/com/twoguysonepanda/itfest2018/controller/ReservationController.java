package com.twoguysonepanda.itfest2018.controller;

import com.twoguysonepanda.itfest2018.entities.Reservation;
import com.twoguysonepanda.itfest2018.service.ReservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping(path = "/add")
    public @ResponseBody Reservation add(
            @RequestParam(required = true) String email,
            @RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam(required = true) Long time
    ) {
        return reservationService.add(email, date, time);
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody Boolean delete(
            @RequestParam(required = true) String email
    ) {
        return reservationService.delete(email);
    }
}
