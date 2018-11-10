package com.twoguysonepanda.itfest2018.service;

import com.twoguysonepanda.itfest2018.entities.Reservation;
import com.twoguysonepanda.itfest2018.entities.User;
import com.twoguysonepanda.itfest2018.entities.enums.UserType;
import com.twoguysonepanda.itfest2018.projections.UserRegister;
import com.twoguysonepanda.itfest2018.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(UserRegister userRegister) {
        userRepository.save(
                new User(
                        userRegister.getUsername(),
                        userRegister.getEmail(),
                        userRegister.getMedic() ? UserType.MEDIC : UserType.DONOR,
                        true,
                        bCryptPasswordEncoder.encode(userRegister.getPassword()),
                        new Date(),
                        new Date(),
                        new Date()
                        ));
    }


    public Boolean addAnalyse(String email, Date donationDate, byte[] analyse) {
        User user = userRepository.findByEmail(email);
        user.setLastDonationDate(donationDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(donationDate);
        cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+6));
        user.setNextDonationDate(cal.getTime());
        user.setAnalyse(analyse);
        userRepository.save(user);

        return true;
    }

    public List<User> donors() {
        return this.userRepository.findAllByType(UserType.DONOR);
    }

    public byte[] analyse(String email) {
        return this.userRepository.findByEmail(email).getAnalyse();
    }
}
