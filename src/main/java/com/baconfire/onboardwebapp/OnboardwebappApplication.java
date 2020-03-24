package com.baconfire.onboardwebapp;

import com.baconfire.onboardwebapp.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableConfigurationProperties({FileStorageProperties.class})
public class OnboardwebappApplication {

    public static void main(String[] args) {

        SpringApplication.run(OnboardwebappApplication.class, args);
    }

}
