package com.example.SpringSec.RestController;

import com.example.SpringSec.Model.Employee;
import com.example.SpringSec.Service.EmploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmploRestController {

    @Autowired
    EmploService emploService;

    @PostMapping("/test/add/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Employee add (@RequestBody Employee emplo){
        return emploService.add(emplo);

    }

    @GetMapping("/test/user/")
    @PreAuthorize("hasAuthority('USER')")
    public String us(){

        return "Witaj user";

    }


    @GetMapping("/test/admin/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String ad(){

        return "Witaj admin";

    }

    @GetMapping("/test/find/{name}")
    public Employee getAll(@PathVariable ("name") String name ){

        return emploService.findByName(name);

    }


}
