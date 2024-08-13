package com.iobit.comercio_vizinho_be.resources;

import com.iobit.comercio_vizinho_be.entities.Address;
import com.iobit.comercio_vizinho_be.services.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/addresses")
public class AddressResource {
    @Autowired
    private AdressService service;

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok()
                             .body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody Address address) {
        address = service.create(address);
        URI
                uri =
                ServletUriComponentsBuilder.fromCurrentRequest()
                                           .path("/{id}")
                                           .buildAndExpand(address.getId())
                                           .toUri();
    }
}
