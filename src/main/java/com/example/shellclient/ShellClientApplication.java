package com.example.shellclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShellClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShellClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
