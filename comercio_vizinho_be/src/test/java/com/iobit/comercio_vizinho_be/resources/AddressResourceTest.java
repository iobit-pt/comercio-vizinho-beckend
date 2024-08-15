package com.iobit.comercio_vizinho_be.resources;

import com.iobit.comercio_vizinho_be.entities.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import java.util.Objects;

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
    void shouldGetAddressById() throws Exception {
        ResponseEntity<Address> response = restTemplate.getForEntity("/addresses/99", Address.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(Objects.requireNonNull(response.getBody())
                          .getId()).isEqualTo(99L);
        assertThat(response.getBody()
                           .getStreet()).isEqualTo("Rua dos bobos");
        assertThat(response.getBody()
                           .getDetail()).isEqualTo("casa engraçada");
        assertThat(response.getBody()
                           .getPostalCode()).isEqualTo("0000-000");
    }

    @Test
    @DirtiesContext
    void shouldCreateANewAddress() throws Exception {

        Address newAddress = new Address(104L, "Rua das jaqueiras", "22", "Casa das jacas", "2400-3333");
        ResponseEntity<Address> response = restTemplate.postForEntity("/addresses", newAddress, Address.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        assertThat(Objects.requireNonNull(response.getBody())
                          .getId()).isNotNull();
        assertThat(response.getBody()
                           .getStreet()).isEqualTo("Rua das jaqueiras");
        assertThat(response.getBody()
                           .getNumber()).isEqualTo("22");
        assertThat(response.getBody()
                           .getPostalCode()).isEqualTo("2400-3333");
        assertThat(response.getBody()
                           .getDetail()).isEqualTo("Casa das jacas");
    }

    @Test
    @DirtiesContext
    void shouldBeAbleToUpdateAnAddress() throws Exception {
        Address updatedAddress = new Address(null, "Rua do Lobo mau", "69", "Toca do lobo", "WOLF-001");
        HttpEntity<Address> request = new HttpEntity<>(updatedAddress);
        ResponseEntity<Void> response = restTemplate.exchange("/addresses/101", HttpMethod.PUT, request, Void.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        ResponseEntity<Address> responseUpdated = restTemplate.getForEntity("/addresses/101", Address.class);

        assertThat(responseUpdated.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(responseUpdated.getBody())
                          .getId()).isEqualTo(101L);
        assertThat(responseUpdated.getBody()
                                  .getStreet()).isEqualTo("Rua do Lobo mau");
        assertThat(responseUpdated.getBody()
                                  .getDetail()).isEqualTo("Toca do lobo");
        assertThat(responseUpdated.getBody()
                                  .getPostalCode()).isEqualTo("WOLF-001");
    }

    @Test
    @DirtiesContext
    void shouldDeleteAnAddress() throws Exception {
        ResponseEntity<Void> response = restTemplate.exchange("/addresses/101", HttpMethod.DELETE, null, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        assertThat(response.getBody()).isNull();

        ResponseEntity<Address> responseDeleted = restTemplate.getForEntity("/addresses/101", Address.class);
        assertThat(responseDeleted.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

    }

}
