package com.example.SpringSec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploService {


    @Autowired EmploRepo emploRepo;


    public Emplo add(Emplo emplo) {


        return emploRepo.save(emplo);

    }

    public Optional<Emplo> findByName(String name) {

        return emploRepo.findByName(name);


    }
}
