package com.Boardimak.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.Boardimak.main.model.Payments;

public interface PaymentRepo extends CrudRepository<Payments, Integer>{

}
