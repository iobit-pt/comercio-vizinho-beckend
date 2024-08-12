package com.iobit.comercio_vizinho_be.resources;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


import javax.swing.*;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressResourceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldGetAllAddress() throws Exception {
        ResponseEntity<List> response = restTemplate.getForEntity("/address", List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(response.getBody()).hasSize(3);
    }

}
