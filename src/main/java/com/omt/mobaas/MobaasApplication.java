package com.omt.mobaas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MobaasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobaasApplication.class, args);
    }


}
