package com.twoguysonepanda.itfest2018.service;

import com.twoguysonepanda.itfest2018.entities.Reservation;
import com.twoguysonepanda.itfest2018.entities.User;
import com.twoguysonepanda.itfest2018.repository.ReservationRepository;
import com.twoguysonepanda.itfest2018.repository.UserRepository;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationService {
    private PagedResourcesAssembler pagedResourcesAssembler;
    private ReservationRepository reservationRepository;
    private UserRepository userRepository;

    public ReservationService(PagedResourcesAssembler pagedResourcesAssembler, ReservationRepository reservationRepository, UserRepository userRepository) {
        this.pagedResourcesAssembler = pagedResourcesAssembler;
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    public Reservation add(String email, Date date, Long time) {
        User user = userRepository.findByEmail(email);
        System.out.println("here");
        return reservationRepository.save(new Reservation(user, date, time));
    }

    public boolean delete(String email) {
        User user = userRepository.findByEmail(email);
        reservationRepository.delete(reservationRepository.findByUser(user));
        return true;
    }
}
