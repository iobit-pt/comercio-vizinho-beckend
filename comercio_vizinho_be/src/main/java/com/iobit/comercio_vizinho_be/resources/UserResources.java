package com.iobit.comercio_vizinho_be.resources;

import com.iobit.comercio_vizinho_be.entities.User;
import com.iobit.comercio_vizinho_be.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok()
                             .body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
        try {
            Optional<User> user = service.findById(id);
            return ResponseEntity.ok()
                                 .body(user);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound()
                                 .build();
        }
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {

        user = service.create(user);
        URI
                uri =
                ServletUriComponentsBuilder.fromCurrentRequest()
                                           .path("/{id}")
                                           .buildAndExpand(user.getId())
                                           .toUri();

        return ResponseEntity.created(uri)
                             .body(user);
    }

}
