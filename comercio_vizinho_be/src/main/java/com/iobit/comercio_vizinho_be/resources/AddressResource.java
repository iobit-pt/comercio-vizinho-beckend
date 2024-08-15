package com.iobit.comercio_vizinho_be.resources;

import com.iobit.comercio_vizinho_be.entities.Address;
import com.iobit.comercio_vizinho_be.services.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Address>> findById(@PathVariable Long id) {
        Optional<Address> address = service.findById(id);
        if (address.isPresent()) {
            return ResponseEntity.ok()
                                 .body(address);
        } else {
            return ResponseEntity.notFound()
                                 .build();
        }
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

        return ResponseEntity.created(uri)
                             .body(address);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody Address updatedAddress) {
        return ResponseEntity.ok()
                             .body(service.update(id, updatedAddress));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                             .build();
    }
}
