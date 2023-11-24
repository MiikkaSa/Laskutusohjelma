package com.Laskutusohjelma.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Laskutusohjelma.domain.AppUser;
import com.Laskutusohjelma.domain.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser currentUser = userRepository.findByUsername(username);

        if (currentUser == null) {
            throw new UsernameNotFoundException("Käyttäjää ei löytynyt: " + username);
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(currentUser.getPasswordHash())
                .roles(currentUser.getRole())
                .build();
    }
}

