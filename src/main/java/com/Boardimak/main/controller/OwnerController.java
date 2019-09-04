package com.Boardimak.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Boardimak.main.model.Owner;
import com.Boardimak.main.service.OwnerService;
import com.Boardimak.main.service.StripeService;
import com.google.gson.JsonObject;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.Token;

@Controller
public class OwnerController {
	
	@Autowired
	StripeService stripeservice;
	
	@Autowired
	OwnerService ownerservice;
	
	@Value("${stripe.key.secret}")
	private String API_SECRET_KEY;

	@GetMapping("/register-owner")
	public String index() {
		return "custom-account";
	}
	
	@PostMapping("/create/owner")
	public String createOwner(@ModelAttribute Owner newOwner, BindingResult bindingResult,HttpServletRequest request) {
		System.out.println(newOwner.getEmail());
		ownerservice.saveOwner(newOwner);
		return "owner-properties";
	}
	
	@PostMapping("/create-account")
    public @ResponseBody
    String createCust(String token, String email) throws StripeException {
		JsonObject result = new JsonObject();
		
		System.out.println("create account called");

        String s = stripeservice.createAccount(token, email);
        if(s.equals("wrong email")) {
        	result.addProperty("isWorking", "wrongEmail");
        }else if(s.equals("already has an account")) {
        	result.addProperty("isWorking", "hasAccount");
        }else {
        	result.addProperty("isWorking", "done");
        }
        
        return result.toString();
	}
	
}
