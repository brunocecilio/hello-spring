package br.com.letscode.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.letscode.hellospring.service.HelloService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        log.trace("request received at /hello, calling hello service");
        return ResponseEntity.ok(helloService.hello());
    }

    @GetMapping("/hello/{name}")
    ResponseEntity<String> helloName(@PathVariable("name") final String name) {
        log.trace("request received at /hello/{name}, calling helloName service");
        return ResponseEntity.ok(helloService.helloName(name));
    }

    @GetMapping("/hello/{name}/horario")
    ResponseEntity<String> helloNameWithHour(@PathVariable("name") final String name) {
        log.trace("request received at /hello/{name}/horario, calling helloNameWithHour service");
        return ResponseEntity.ok(helloService.helloNameWithHour(name));
    }

}
