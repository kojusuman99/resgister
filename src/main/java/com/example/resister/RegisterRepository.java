package com.example.resister;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RegisterRepository extends CrudRepository<Register, Integer> {

    Optional<Register> findByName(String name);
}
