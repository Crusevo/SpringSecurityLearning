package com.example.SpringSec.Security;


import com.example.SpringSec.Repository.EmploRepo;
import com.example.SpringSec.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    EmploRepo emploRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Employee byName = emploRepo.findByEmploName(username);

        if(byName == null) throw new UsernameNotFoundException("Not found");

        return new MyUserDetails(byName);
    }
}
