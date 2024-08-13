package com.iobit.comercio_vizinho_be.resources;

import com.iobit.comercio_vizinho_be.entities.Address;
import com.iobit.comercio_vizinho_be.services.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/addresses")
public class AddressResource {
    @Autowired
    private AdressService service;

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
