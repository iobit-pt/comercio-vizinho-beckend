package com.iobit.comercio_vizinho_be.repositories;

import com.iobit.comercio_vizinho_be.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
