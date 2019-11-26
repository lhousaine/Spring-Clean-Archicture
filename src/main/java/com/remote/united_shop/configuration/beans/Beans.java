package com.remote.united_shop.configuration.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class Beans {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}