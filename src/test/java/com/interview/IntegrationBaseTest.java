package com.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

//@TestPropertySource({"spring.datasource.url=jdbc:postgresql://localhost:5432/world-db",
//        "spring.datasource.username=world",
//        "spring.datasource.password=world123"
//})

@SpringBootTest
@AutoConfigureMockMvc
public abstract class IntegrationBaseTest {

    @Autowired
    protected MockMvc mockMvc;

}
