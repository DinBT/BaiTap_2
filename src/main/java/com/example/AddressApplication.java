package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(AddressApplication.class, args);
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

}
