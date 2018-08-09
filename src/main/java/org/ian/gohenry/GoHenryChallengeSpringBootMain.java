package org.ian.gohenry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
@SpringBootApplication
public class GoHenryChallengeSpringBootMain {
    /**
     * main method to run the spring boot app.
     *
     * @param args the arguments passed to the app.
     */
    public static void main(String[] args) {

        SpringApplication.run(GoHenryChallengeSpringBootMain.class, args);
    }
}
