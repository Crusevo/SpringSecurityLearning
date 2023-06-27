package com.example.SpringSec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmploRestController {

    @Autowired EmploService emploService;

    @PostMapping("/test/add/")
    public Emplo add (@RequestBody Emplo emplo){


        return emploService.add(emplo);

    }

    @GetMapping("/test/user/")
    public String us(){

        return "Witaj user";

    }


    @GetMapping("/test/admin/")
    public String ad(){

        return "Witaj admin";

    }

    @GetMapping("/test/find/{name}")
    public Optional<Emplo> getAll(@PathVariable ("name") String name ){

        return emploService.findByName(name);

    }


}
