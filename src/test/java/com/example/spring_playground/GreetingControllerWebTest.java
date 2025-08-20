package com.example.spring_playground;

import com.example.spring_playground.controller.GreetingController;
import com.example.spring_playground.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GreetingController.class)
class GreetingControllerWebTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ApplicationContext context;

    @MockitoBean
    GreetingService greetingService = Mockito.mock(GreetingService.class);

    @Test
    void greetEndpoint_WhenCalledWithHans_ShouldReturnHalloHans() throws Exception {
        when(greetingService.greet("Hans")).thenReturn("Hallo, Hans!");

        mvc.perform(get("/greet/Hans"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hallo, Hans!"));
    }

    @Test
    void greetAllEndpoint_WhenCalled_ShouldReturnMultipleGreetings() throws Exception {
        when(greetingService.greetAll()).thenReturn("Hallo Hans. Hallo Peter.");

        mvc.perform(get("/greetAll"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hallo Hans. Hallo Peter."));
    }

    // ---------------------------------------------------------------------------------------


    @Test
    void printBeans() {
        String[] beans = context.getBeanDefinitionNames();
        System.out.println("==== Beans geladen von @WebMvcTest ====");
        for (String bean : beans) {
            System.out.println(bean);
        }
        System.out.println("Anzahl Beans: " + beans.length);
    }
}
