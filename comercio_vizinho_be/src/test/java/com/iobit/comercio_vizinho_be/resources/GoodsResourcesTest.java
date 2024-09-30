package com.iobit.comercio_vizinho_be.resources;

import com.iobit.comercio_vizinho_be.entities.Goods;
import com.iobit.comercio_vizinho_be.entities.User;
import com.iobit.comercio_vizinho_be.entities.enums.GoodsType;
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

        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().size()).isGreaterThan(3);
        assertThat(response.getBody().size()).isEqualTo(6);

    }

    @Test
    void shouldGetAGoodById() throws Exception {
        ResponseEntity<Goods> response = restTemplate.getForEntity("/goods/99", Goods.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldGetAllProducts() throws Exception {
        ResponseEntity<List> response = restTemplate.getForEntity("/goods/products", List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().size()).isEqualTo(3);
    }

    @Test
    void shouldGetAProductById() throws Exception {
        ResponseEntity<Goods> response = restTemplate.getForEntity("/goods/products/101", Goods.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    void shouldGetAllServices() throws Exception {
        ResponseEntity<List> response = restTemplate.getForEntity("/goods/services", List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().size()).isEqualTo(3);
    }

    @Test
    void shouldGetAServiceById() throws Exception {
        ResponseEntity<Goods> response = restTemplate.getForEntity("/goods/services/105", Goods.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    }


    @Test
    void shouldCreateNewGood() throws Exception {

        User user = restTemplate.getForEntity("/users/99", User.class).getBody();

        Goods newGood = new Goods(null, "Massagem", "Faço massagens", 1.33, GoodsType.PRODUCT, user);
        ResponseEntity<Goods> response = restTemplate.postForEntity("/goods", newGood, Goods.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        assertThat(response.getBody()).isNotNull();
    }

    @Test
    void shouldUpdateAGood() throws Exception {

        ResponseEntity<Goods> goodToUpdate = restTemplate.getForEntity("/goods/101", Goods.class);
        assertThat(goodToUpdate.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(goodToUpdate.getBody()).isNotNull();

        goodToUpdate.getBody().setName("Massagem2");

        HttpEntity<Goods> request = new HttpEntity<>(goodToUpdate.getBody());
        ResponseEntity<Void> response = restTemplate.exchange("/goods/101", HttpMethod.PUT, request, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(goodToUpdate.getBody()).isNotNull();

        ResponseEntity<Goods> updatedGoods = restTemplate.getForEntity("/goods/101", Goods.class);
        assertThat(updatedGoods.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(updatedGoods.getBody()).isNotNull();
        assertThat(updatedGoods.getBody().getName()).isEqualTo("Massagem2");

    }

    @Test
    void shouldDeleteAGood() throws Exception {
        ResponseEntity<Void> response = restTemplate.exchange("/goods/101", HttpMethod.DELETE, null, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        assertThat(response.getBody()).isNull();

        ResponseEntity<Goods> responseDeleted = restTemplate.getForEntity("/goods/101", Goods.class);
        assertThat(responseDeleted.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

    }


}
