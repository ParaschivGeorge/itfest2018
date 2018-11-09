package com.twoguysonepanda.itfest2018.security.service;

import com.twoguysonepanda.itfest2018.entities.User;
import com.twoguysonepanda.itfest2018.repository.UserRepository;
import com.twoguysonepanda.itfest2018.security.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(mail);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", mail));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
