package com.iobit.comercio_vizinho_be.entities;

import com.iobit.comercio_vizinho_be.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository repository;

    @Test
    @DirtiesContext
    void shouldCreateANewUser() {
        User user01 = new User(null, "Jaca", "jaca@melao.com", 999999999, "");
        User user02 = new User(null, "Uva", "uva@melao.com", 999999999, "");
        User user03 = new User(null, "Abacate", "abacate@melao.com", 999999999, "");

        repository.saveAll(Arrays.asList(user01, user02, user03));

        assertThat(repository.findById(1L)).contains(user01);
        assertThat(repository.findById(2L)).contains(user02);
        assertThat(repository.findById(3L)).contains(user03);

    }


}
