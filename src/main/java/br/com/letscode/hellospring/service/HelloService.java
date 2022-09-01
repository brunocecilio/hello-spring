package br.com.letscode.hellospring.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HelloService {

    private static final DateTimeFormatter HOUR_MINUTE_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public String hello() {
        log.trace("hello service executing");
        return "Hello!";
    }

    public String helloName(final String name) {
        log.trace("helloName service executing for name={" + name + "}");
        return "Hello " + name + "!";
    }

    public String helloNameWithHour(final String name) {
        final String nowString = LocalDateTime.now().format(HOUR_MINUTE_FORMATTER);
        log.trace("helloNameWithHour service executing for name={" + name + "} at " + nowString);
        return "Hello " + name + "! Agora são " + nowString + ", não esqueça!";
    }

}
