package it.scislowski.bluemix.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
