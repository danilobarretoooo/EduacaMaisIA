package dev.danilobarreto.portalaluno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "dev.danilobarreto.portalaluno")
public class PortalAlunoApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortalAlunoApplication.class, args);
    }

}
