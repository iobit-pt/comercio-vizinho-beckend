package com.iobit.comercio_vizinho_be.resources;

import com.iobit.comercio_vizinho_be.entities.Goods;
import com.iobit.comercio_vizinho_be.repositories.GoodsRepository;
import com.iobit.comercio_vizinho_be.services.GoodsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/goods")
public class GoodsResources {

    private final GoodsService goodsService;

    public GoodsResources(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping
    public ResponseEntity<List<Goods>> findAll() {
        return ResponseEntity.ok().body(goodsService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Goods>> findById(@PathVariable Long id) {
        try {
            Optional<Goods> goods = goodsService.findById(id);
            return ResponseEntity.ok().body(goods);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
