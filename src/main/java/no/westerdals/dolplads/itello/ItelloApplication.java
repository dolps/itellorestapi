package no.westerdals.dolplads.itello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Application added at https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku#preparing-a-spring-boot-app-for-heroku
 * <p>
 * open app from Terminal with the heroku open command
 * see logs with the heroku logs --tail
 */
@SpringBootApplication
public class ItelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItelloApplication.class, args);
    }
}
