package com.iobit.comercio_vizinho_be.resources;

import com.iobit.comercio_vizinho_be.entities.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;


import javax.swing.*;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressResourceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DirtiesContext
    void shouldGetAllAddress() throws Exception {
        ResponseEntity<List> response = restTemplate.getForEntity("/addresses", List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(response.getBody()).hasSize(3);
    }

    @Test
    @DirtiesContext
    void shouldCreateANewAddress() throws Exception {

        Address newAddress = new Address(104L, "Rua das jaqueiras", "22", "Casa das jacas", "2400-3333");
        ResponseEntity<Address> response = restTemplate.postForEntity("/addresses", newAddress, Address.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        assertThat(response.getBody()
                           .getId()).isEqualTo(104L);
    }

}
