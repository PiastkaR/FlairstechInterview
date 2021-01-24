package com.interview.controller;

import com.interview.exception.InvalidCountryCode;
import com.interview.service.BusinessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CountryCodeController.class)
class CountryCodeControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BusinessService businessService;

    @Test
    void shouldThrowInvalidCountryCode() throws Exception {
        //Arrange
        when(businessService.getCountryInfo(anyString())).thenThrow(InvalidCountryCode.class);

        //Act &  Assert
        mockMvc.perform(get("/wrong")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }

    @Test
    void shouldThrowInternalServerError() throws Exception {
        //Arrange
        when(businessService.getCountryInfo(anyString())).thenThrow(InternalError.class);

        //Act
        mockMvc.perform(get("/BHR")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is5xxServerError());

        //Assert
    }


}