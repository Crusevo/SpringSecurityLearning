package com.example.SpringSec.Service;

import com.example.SpringSec.Model.Employee;
import com.example.SpringSec.Repository.EmploRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmploService {


    @Autowired
    EmploRepo emploRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public Employee add(Employee emplo) {

        String encodedPassword = bCryptPasswordEncoder.encode(emplo.getPassword());

        emplo.setPassword(encodedPassword);

        return emploRepo.save(emplo);
    }

    public Employee findByName(String name) {
        return emploRepo.findByEmploName(name);
    }
}
