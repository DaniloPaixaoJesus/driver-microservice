package br.com.danilopaixao.driver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.danilopaixao.driver.model.Driver;

public interface DriverRepository extends MongoRepository<Driver, String> {
}