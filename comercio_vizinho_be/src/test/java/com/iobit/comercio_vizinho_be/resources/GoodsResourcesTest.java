package com.iobit.comercio_vizinho_be.resources;

import com.iobit.comercio_vizinho_be.entities.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoodsResourcesTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldGetAllGoods() throws Exception {
        ResponseEntity<List> response = restTemplate.getForEntity("/goods", List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    void shouldGetAllProducts() throws Exception {
        ResponseEntity<List> response = restTemplate.getForEntity("/goods/products", List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldGetAllServices() throws Exception {
        ResponseEntity<List> response = restTemplate.getForEntity("/goods/services", List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldGetAGoodById() throws Exception {
        ResponseEntity<List> response = restTemplate.getForEntity("/goods/99", List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldCreateNewGood() throws Exception {
        Goods newGood = new Goods();
        ResponseEntity<Goods> response = restTemplate.postForEntity("/goods", newGood, Goods.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void shouldUpdateAGood() throws Exception {
        Goods updatedGood = new Goods();
        HttpEntity<Goods> request = new HttpEntity<>(updatedGood);
        ResponseEntity<Void>
                response =
                restTemplate.exchange("/goods/101", HttpMethod.PUT, request, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldDeleteAGood() throws Exception {
        ResponseEntity<Void> response = restTemplate.exchange("/goods/101", HttpMethod.DELETE, null, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        assertThat(response.getBody()).isNull();

        ResponseEntity<Goods> responseDeleted = restTemplate.getForEntity("/addresses/101", Goods.class);
        assertThat(responseDeleted.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

    }


}
