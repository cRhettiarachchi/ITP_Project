package com.Boardimak.main.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Boardimak.main.repository.*;
import com.Boardimak.main.model.*;


@Service
public class UserService {

	@Autowired
	private UserRepo jpaRepo;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private ProposalRepo proposalrepo;
	
	
	public ArrayList<Buyer> getAllUsers(){
		ArrayList<Buyer> users = new ArrayList<>();
		jpaRepo.findAll().forEach(users::add);
		return users;
	}
	
	public Buyer getUser(int id){
		return jpaRepo.findById(id).get();
	}
	
	public void updateStripeID( Buyer buyer ) {
		jpaRepo.save(buyer);
	}

	public Buyer getIdByEmail(String email) {

		Buyer id = jpaRepo.findAllByEmail(email);
		return id;
	}

	public void createUser(User request) {
		userRepository.save(request);
	}

	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public void updateUser(User request) {
		User user = getUserById(request.getId());
		if (user != null) {
			user = User.updateUser(user, request);
			userRepository.save(user);
		}

	}

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
	/*Sending a proposal from the Parent or the Student*/
	public void saveProposal(Proposal p) {
		proposalrepo.save(p);
	}
	
	public ArrayList<Proposal> findProposals() {
		ArrayList<Proposal> proposals = new ArrayList<>();
		proposalrepo.findAll().forEach(proposals::add);
		return proposals;
	}

	public void deleteProposal(int id) {
		proposalrepo.deleteById(id);
	}
}
