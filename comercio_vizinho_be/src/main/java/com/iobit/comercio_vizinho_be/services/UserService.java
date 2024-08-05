package com.iobit.comercio_vizinho_be.services;

import com.iobit.comercio_vizinho_be.entities.User;
import com.iobit.comercio_vizinho_be.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
