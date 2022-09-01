package br.com.letscode.hellospring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.letscode.hellospring.controller.HelloController;
import br.com.letscode.hellospring.service.HelloService;

@AutoConfigureMockMvc
@SpringBootTest(classes = { HelloController.class, HelloService.class })
class HelloTests {

    @Autowired
    MockMvc mvc;

    @Test
    void helloEndpoint() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello!"));
    }

    @Test
    void helloNameEndpoint() throws Exception {
        final String testName = "Nome Completo de Teste";

        mvc.perform(MockMvcRequestBuilders
                .get("/hello/" + testName))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello " + testName + "!"));
    }

    @Test
    void helloNameWithHourEndpoint() throws Exception {
        final String testName = "Nome Completo de Teste";
        final String nowString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));

        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get("/hello/" + testName + "/horario"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals(result.getResponse().getContentAsString(),
                "Hello " + testName + "! Agora são " + nowString + ", não esqueça!");
    }

}
