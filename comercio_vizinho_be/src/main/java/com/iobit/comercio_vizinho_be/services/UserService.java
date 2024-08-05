package com.iobit.comercio_vizinho_be.services;

import com.iobit.comercio_vizinho_be.entities.User;
import com.iobit.comercio_vizinho_be.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User create(User user) {
        return repository.save(user);
    }

    public Optional<User> findById(Long id) {
        Optional<User> user = repository.findById(id);
        return Optional.ofNullable(user.orElseThrow(RuntimeException::new));
    }
}
