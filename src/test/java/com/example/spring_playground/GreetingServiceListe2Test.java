package com.example.spring_playground;

import com.example.spring_playground.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("Liste2")
@TestPropertySource(properties = "app.greeting.prefix=Hello")
class GreetingServiceListe2Test {

    @Autowired
    GreetingService greetingService;

    @Test
    void greet() {
        assertThat(greetingService.greet("Justin"))
                .isEqualTo("Hello, Justin!");
    }

    @Test
    void greetAll() {
        assertThat(greetingService.greetAll())
                .isEqualTo("Hello John. Hello Bob. Hello Mike. Hello Jake.");
    }
}
