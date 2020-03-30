package com.baconfire.onboardwebapp;

import com.baconfire.onboardwebapp.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableConfigurationProperties({FileStorageProperties.class})
@EnableAspectJAutoProxy
public class OnboardwebappApplication {

    public static void main(String[] args) {

        SpringApplication.run(OnboardwebappApplication.class, args);
    }

}
