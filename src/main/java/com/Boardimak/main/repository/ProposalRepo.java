package com.Boardimak.main.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Boardimak.main.model.Proposal;

public interface ProposalRepo extends JpaRepository<Proposal, Integer>{

}
