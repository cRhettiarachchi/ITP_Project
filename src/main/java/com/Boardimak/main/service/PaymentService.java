package com.Boardimak.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Boardimak.main.model.Payments;
import com.Boardimak.main.model.Property;
import com.Boardimak.main.repository.PaymentRepo;
import com.stripe.model.PaymentIntent;

@Service
public class PaymentService {

	
	@Autowired
	private PaymentRepo paymentRepo;

	
	public void createPayment(Payments p) {
		paymentRepo.save(p);
	}
	
	public void createPaymentObject(PaymentIntent p) {
		
		long amount = (long) (p.getAmount() + (p.getAmount()*0.8));
		String method = "visa";
		String status = p.getStatus();
		String payment_token = p.getId();
		
		Payments pay = new Payments(amount, status, 10001, method, payment_token);
		createPayment(pay);
		System.out.println("createPaymentObjectWorking");
		
//		createPayment(payment);
	}
	
	public List<Payments> showAll() {
		List<Payments> properties = new ArrayList<>();
			for(Payments propertyObject : paymentRepo.findAll()) {
				properties.add(propertyObject);
			}
		return properties;
	}
}
