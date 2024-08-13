package com.iobit.comercio_vizinho_be.resources;

import com.iobit.comercio_vizinho_be.entities.User;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserResourceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DirtiesContext
    void shouldGetAllUsers() throws Exception {

        ResponseEntity<List> response = restTemplate.getForEntity("/users", List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(response.getBody()).hasSize(3);

    }

    @Test
    @DirtiesContext
    void shouldGetAUserByIdIfItExists() throws Exception {
        ResponseEntity<User> response = restTemplate.getForEntity("/users/99", User.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(response.getBody()
                           .getName()).isEqualTo("New User");
    }


    @Test
    @DirtiesContext
    void shouldBeAbleToCreateAnUser() throws Exception {

        User newUser = new User(null, "New User2", "newuser@email.com", 999999, "");

        ResponseEntity<User> createResponse = restTemplate.postForEntity("/users", newUser, User.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        assertThat(createResponse.getBody()
                                 .getId()).isEqualTo(1L);
        assertThat(createResponse.getBody()
                                 .getName()).isEqualTo("New User2");

    }

//    TODO: CREATE TESTS FOR OTHER CRUD OPERATIONS



}
