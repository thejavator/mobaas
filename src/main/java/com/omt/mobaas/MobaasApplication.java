package com.omt.mobaas;

import com.omt.mobaas.model.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class MobaasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobaasApplication.class, args);
    }


}
