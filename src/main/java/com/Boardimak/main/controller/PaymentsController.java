package com.Boardimak.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Boardimak.main.service.PaymentService;
import com.Boardimak.main.service.StripeService;
import com.stripe.exception.StripeException;

@Controller
public class PaymentsController {

	@Autowired
	private PaymentService paymentservice;
	
	@Autowired StripeService stripeservice;
	
	
//	@GetMapping("/payment/details")
//	public void paymentDetails() {
//		paymentservice.createPayment(p);
//		System.out.println(p.getAmount());
//	}
	
	@GetMapping("/pay/owner")
	public void payment() throws StripeException {

		stripeservice.createPayment();
	}
	
	@GetMapping("/payment/details")
	public String showProperties(HttpServletRequest request) {
		request.setAttribute("payments",paymentservice.showAll());
		return "payment-details";
	}
}
