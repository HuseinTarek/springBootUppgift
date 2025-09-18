package org.rest.now.testrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.rest.now.testrest", "controller", "Service"})

public class TestRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRestApplication.class, args);
    }

}
