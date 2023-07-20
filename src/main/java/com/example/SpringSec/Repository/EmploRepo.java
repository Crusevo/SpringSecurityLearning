package com.example.SpringSec.Repository;

import com.example.SpringSec.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmploRepo extends JpaRepository <Employee, Long> {

    @Query
    Employee findByEmploName(String name);



}
