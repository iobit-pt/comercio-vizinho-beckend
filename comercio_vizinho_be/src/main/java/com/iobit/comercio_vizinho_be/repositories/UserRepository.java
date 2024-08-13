package com.iobit.comercio_vizinho_be.repositories;

import com.iobit.comercio_vizinho_be.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
}
