package com.iobit.comercio_vizinho_be.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iobit.comercio_vizinho_be.entities.User;
import com.iobit.comercio_vizinho_be.services.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(UserResources.class)
public class UserResource {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DirtiesContext
    void shouldGetAllUsers() throws Exception {

        User user01 = new User(null, "Jaca", "jaca@melao.com", 999999999, "");
        User user02 = new User(null, "Uva", "uva@melao.com", 999999999, "");
        User user03 = new User(null, "Abacate", "abacate@melao.com", 999999999, "");

        // Mocks the service when it is requested
        when(service.findAll()).thenReturn(Arrays.asList(user01, user02, user03));

        //Performs an http reuqest to mocked endpoint.
        String response = mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                                 .andExpect(MockMvcResultMatchers.status()
                                                                 .isOk())
                                 .andReturn()
                                 .getResponse()
                                 .getContentAsString();

        List<User> parsedUser = objectMapper.readValue(response, List.class);
        assertThat(parsedUser).hasSize(3);

    }

    @Test
    void shouldGetAUserByIdIfItExists() throws Exception {
        User user02 = new User(2L, "Uva", "uva@melao.com", 999999999, "");

        when(service.findById(1L)).thenReturn(Optional.empty());
        when(service.findById(2L)).thenReturn(Optional.of(user02));

        String
                response =
                mockMvc.perform(MockMvcRequestBuilders.get("/users/" + 2L))
                       .andExpect(MockMvcResultMatchers.status()
                                                       .isOk())
                       .andReturn()
                       .getResponse()
                       .getContentAsString();

        User parsedObject = objectMapper.readValue(response, User.class);

        assertThat(parsedObject).isEqualTo(user02);

        String
                responseNull =
                mockMvc.perform(MockMvcRequestBuilders.get("/users/" + 1L))
                       .andExpect(MockMvcResultMatchers.status()
                                                       .isOk())
                       .andReturn()
                       .getResponse()
                       .getContentAsString();
        User parsedNull = objectMapper.readValue(responseNull, User.class);
        assertThat(parsedNull).isNull();
    }

}
