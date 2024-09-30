package com.iobit.comercio_vizinho_be.repositories;


import com.iobit.comercio_vizinho_be.entities.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long>, JpaSpecificationExecutor<Goods> {
    List<Goods> findByGoodsType(Integer goodsType);

}
