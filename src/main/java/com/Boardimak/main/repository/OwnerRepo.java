package com.Boardimak.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.Boardimak.main.model.Owner;

public interface OwnerRepo extends CrudRepository<Owner, Integer>{

	// custom method to get buyer using the email
	Owner findAllByEmail(String email);
}
