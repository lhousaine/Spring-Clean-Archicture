package com.remote.united_shop;

import com.remote.united_shop.Core.InitData.Initializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class UnitedShopApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(UnitedShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Initializer.InitBD();
    }

    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
}
