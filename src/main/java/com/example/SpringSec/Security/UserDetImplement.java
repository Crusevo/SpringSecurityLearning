package com.example.SpringSec.Security;

import com.example.SpringSec.Emplo;
import com.example.SpringSec.EmploRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetImplement implements UserDetailsService {

    @Autowired
    EmploRepo emploRepo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<Emplo> employEntity = emploRepo.findByName(name);

       employEntity.orElseThrow(() -> new UsernameNotFoundException("Not found"));

        return employEntity.map(UserDetailSer::new).get();


    }
}
