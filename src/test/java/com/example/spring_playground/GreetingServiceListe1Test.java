package com.example.spring_playground;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.spring_playground.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@ActiveProfiles("Liste1")
@TestPropertySource(properties = "app.greeting.prefix=Hallo")
class GreetingServiceListe1Test {

    @Autowired
    GreetingService greetingService;

    @Autowired
    ApplicationContext context;

    @Test
    void greet() {
        assertThat(greetingService.greet("Einstein"))
                .isEqualTo("Hallo, Einstein!");
    }

    @Test
    void greetAll() {
        assertThat(greetingService.greetAll())
                .isEqualTo("Hallo Hans. Hallo Peter. Hallo Lisa. Hallo Martin.");
    }

    // ---------------------------------------------------------------------------------------


    @Test
    void printBeans() {
        String[] beans = context.getBeanDefinitionNames();
        System.out.println("==== Beans geladen von @WSpringBootTest ====");
        for (String bean : beans) {
            System.out.println(bean);
        }
        System.out.println("Anzahl Beans: " + beans.length);
    }
}
