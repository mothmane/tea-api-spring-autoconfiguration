package com.othmane;


import com.othmane.services.TeaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class TeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeaApplication.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TeaService teaService){

        return args -> {
            System.out.println(teaService.drink());
        };


    }

}
