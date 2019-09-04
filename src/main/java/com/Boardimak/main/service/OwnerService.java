package com.Boardimak.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Boardimak.main.model.Owner;
import com.Boardimak.main.repository.OwnerRepo;

@Service
public class OwnerService {

	OwnerRepo ownerRepo;
	Owner ownerObj;
	
	@Autowired
	public OwnerService(OwnerRepo sRepo) {
		this.ownerRepo = sRepo;
	}
	
	public Owner getAllusersByemail(String email) {
		Owner o = ownerRepo.findAllByEmail(email);
		return o;
	}
	
	public void saveOwner(Owner newOwner) {
		ownerRepo.save(newOwner);
	}
}
