package ru.nokisev.springinaction.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class) // Тест для HomeController
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc; // Внедрить MockMvc

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) // Выполнить GET-запрос
                .andExpect(status().isOk()) // Ожидается код ответа HTTP 200
                .andExpect(view().name("home")) // Ожидается представление home
                .andExpect(content().string( // Ожидается наличие определение строки
                        containsString("Welcome to...")
                ));
    }
}