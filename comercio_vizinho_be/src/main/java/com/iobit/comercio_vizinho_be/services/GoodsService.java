package com.iobit.comercio_vizinho_be.services;

import com.iobit.comercio_vizinho_be.entities.Goods;
import com.iobit.comercio_vizinho_be.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository repository;

    public List<Goods> findAll() {return repository.findAll();}

    public Optional<Goods> findById(Long id) {
        Optional<Goods> goods = repository.findById(id);
        return Optional.ofNullable(goods.orElseThrow(RuntimeException::new));
    }

    public List<Goods> findAllGoodsByType(Integer goodsType) {
        return repository.findByGoodsType(goodsType);
    }
}
