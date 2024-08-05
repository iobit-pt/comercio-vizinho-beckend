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


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserResourceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DirtiesContext
    void shouldGetAllUsers() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity("/users",  String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

//        TODO: put here the other assertions



    }

    @Test
    @DirtiesContext
    void shouldGetAUserByIdIfItExists() throws Exception {
        ResponseEntity<User> response = restTemplate.getForEntity("/users/99", User.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


    @Test
    @DirtiesContext
    void shouldBeAbleToCreateAnUser() throws Exception {

        User newUser = new User(null, "New User", "newuser@email.com", 999999, "");

        ResponseEntity<Void> createResponse = restTemplate.postForEntity("/users", newUser, Void.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

    }


}
