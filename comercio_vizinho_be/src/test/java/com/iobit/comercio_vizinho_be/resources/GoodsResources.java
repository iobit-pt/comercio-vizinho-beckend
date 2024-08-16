package com.iobit.comercio_vizinho_be.resources;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoodsResources {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldGetAllGoods() throws Exception {
    }

    @Test
    void shouldGetAllProducts() throws Exception {
    }

    @Test
    void shouldGetAllServices() throws Exception {
    }

    @Test
    void shouldGetAGoodById() throws Exception {
    }

    @Test
    void shouldCreateNewGood() throws Exception {
    }

    @Test
    void shouldUpdateAGood() throws Exception {
    }

    @Test
    void shouldDeleteAGood() throws Exception {
    }


}
