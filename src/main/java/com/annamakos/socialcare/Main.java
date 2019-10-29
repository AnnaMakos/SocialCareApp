package com.annamakos.socialcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class Main {

    @RequestMapping(value="/xd", method= RequestMethod.GET)
    public String welcome(){
        return "hello Anja";
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
