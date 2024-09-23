package com.iobit.comercio_vizinho_be.repositories;


import com.iobit.comercio_vizinho_be.entities.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
