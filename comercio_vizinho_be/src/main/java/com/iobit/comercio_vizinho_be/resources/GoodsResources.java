package com.iobit.comercio_vizinho_be.resources;

import com.iobit.comercio_vizinho_be.entities.Goods;
import com.iobit.comercio_vizinho_be.services.GoodsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "/products")
    public ResponseEntity<List<Goods>> findAllProducts() {
        return ResponseEntity.ok().body(goodsService.findAllGoodsByType(1));
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Optional<Goods>> findProductById(@PathVariable Long id) {
        try {
            Optional<Goods> product = goodsService.findById(id);
            return ResponseEntity.ok().body(product);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/services")
    public ResponseEntity<List<Goods>> findAllServices() {
        return ResponseEntity.ok().body(goodsService.findAllGoodsByType(2));
    }

    @GetMapping(value = "/services/{id}")
    public ResponseEntity<Optional<Goods>> findServiceById(@PathVariable Long id) {
        try {
            Optional<Goods> product = goodsService.findById(id);
            return ResponseEntity.ok().body(product);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Goods> create(@RequestBody Goods good) {
        good = goodsService.create(good);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(good.getId()).toUri();

        return ResponseEntity.created(uri).body(good);
    }


}
