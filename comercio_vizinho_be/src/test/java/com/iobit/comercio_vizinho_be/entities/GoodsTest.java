package com.iobit.comercio_vizinho_be.entities;

import com.iobit.comercio_vizinho_be.entities.enums.GoodsType;
import com.iobit.comercio_vizinho_be.repositories.GoodsRepository;
import com.iobit.comercio_vizinho_be.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GoodsTest {
    @Autowired
    private GoodsRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DirtiesContext
    void shouldCreateNewGoods() {

        User user01 = new User(null, "Jaca", "jaca@melao.com", 999999999, "");
        userRepository.save(user01);


        Goods goods01 = new Goods(null, "Pêssego dos grandes", "Esse é dos bons e nacional", 1.85d, GoodsType.PRODUCT, user01);
        Goods goods02 = new Goods(null, "Pêssego dos grandes", "Esse é dos bons e nacional", 1.85d, GoodsType.PRODUCT, user01);
        Goods goods03 = new Goods(null, "Pêssego dos grandes", "Esse é dos bons e nacional", 1.85d, GoodsType.PRODUCT, user01);


        repository.saveAll(Arrays.asList(goods01, goods02, goods03));

        assertThat(repository.findById(1L)).contains(goods01);
        assertThat(repository.findById(2L)).contains(goods02);
        assertThat(repository.findById(3L)).contains(goods03);

    }
}
