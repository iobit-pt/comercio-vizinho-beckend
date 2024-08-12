package com.iobit.comercio_vizinho_be.services;

import com.iobit.comercio_vizinho_be.entities.Address;
import com.iobit.comercio_vizinho_be.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressService {
    @Autowired
    private AddressRepository repository;

    //    TODO: METHODS HERE
    public List<Address> findAll() {
        return repository.findAll();
    }
}
