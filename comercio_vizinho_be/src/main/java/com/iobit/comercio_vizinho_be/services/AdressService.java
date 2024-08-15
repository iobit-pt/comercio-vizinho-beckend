package com.iobit.comercio_vizinho_be.services;

import com.iobit.comercio_vizinho_be.entities.Address;
import com.iobit.comercio_vizinho_be.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressService {
    @Autowired
    private AddressRepository repository;

    //    TODO: METHODS HERE
    public List<Address> findAll() {
        return repository.findAll();
    }

    public Address create(Address address) {
        return repository.save(address);
    }

    public Optional<Address> findById(Long id) {
        return repository.findById(id);
    }

    public Address update(Long id, Address updatedAddress) {
        Address entity = repository.getReferenceById(id);
        updateData(entity, updatedAddress);
        return repository.save(entity);
    }

    private void updateData(Address entity, Address obj) {
        entity.setNumber(obj.getNumber());
        entity.setDetail(obj.getDetail());
        entity.setStreet(obj.getStreet());
        entity.setPostalCode(obj.getPostalCode());
    }

    public NullValue delete(Long id) {
        repository.deleteById(id);
        return null;

    }
}
