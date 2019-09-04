package com.Boardimak.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.Boardimak.main.model.*;
import com.Boardimak.main.service.StripeService;
import com.Boardimak.main.service.UserService;
import com.google.gson.JsonObject;
import com.Boardimak.main.model.Proposal;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private StripeService stripeService;
	
	@Value("${stripe.key.secret}")
	private String API_SECRET_KEY;
	
	@GetMapping("/register-payment")
	public String registerPay() {
		return "register-payment";
	}
	
	@GetMapping("/users")
	public ArrayList<Buyer> getAllUsers(){
		return userservice.getAllUsers();
		
	}
	
	@GetMapping("/user/{id}")
	public String getUser(@PathVariable int id){
		Buyer b;
		b =  userservice.getUser(id);
		int ID = b.getId();
		String lastname = b.getStripeID();
		return lastname;
	}
	
	// create stripe customer
	@PostMapping("/createCust")
    public @ResponseBody
    String createCust(String token, String email) {

		JsonObject result = new JsonObject();
        String customerId = stripeService.createCustomer(token, email);
        if(customerId.equals("Wrong Email")){
        	result.addProperty("isWorking", "wrongEmail");
        }else if(customerId.equals("Alread Have An Account") ) {
        	result.addProperty("isWorking", "hasAccount");
        }else {
        	result.addProperty("isWorking", "done");
        }
        return result.toString();
	}

	@GetMapping("/users/all")
    public String showProperties(HttpServletRequest request) {
        request.setAttribute("users",userservice.getAllUsers());
        return "users";
    }

    @RequestMapping("/user/update/view")
    public String updateUserView(@RequestParam int id,HttpServletRequest request) {
	    request.setAttribute("user", userservice.getUserById(id));
	    return "settings";
    }

    @PostMapping("/user")
    public String saveObject(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
        userservice.createUser(user);
        return "redirect:/users/all";
    }

    @PostMapping("/user/update")
    public String updateSettings(@ModelAttribute User user) {
        userservice.updateUser(user);
        return "redirect:/settings";
    }

    @RequestMapping("/user/delete")
    public String deleteUser(@RequestParam int id,HttpServletRequest request) {

        return "redirect:/users/all";
    }
    
    /*Proposal requests*/ 
    @PostMapping("/submit/proposal")
    public String submitMessage(@ModelAttribute Proposal newProposal, BindingResult bindingResult,HttpServletRequest request) {
    	userservice.saveProposal(newProposal);
    	return "index";
    }
    
    @RequestMapping("/view/Proposals")
    public String viewProposals(@RequestParam int id, HttpServletRequest request) {
    	ArrayList<Proposal> proposals = new ArrayList<>();
    	for(Proposal p: userservice.findProposals()) {
    		if(p.getUser_id() == id) {
    			proposals.add(p);
    		}
    	}
    	request.setAttribute("proposals", proposals);
    	return "view-proposals";
    }
    
    @RequestMapping("/delete/proposal")
    public String deleteProposal(@RequestParam int id, @RequestParam int userId, HttpServletRequest request) {
    	userservice.deleteProposal(id);
    	return "redirect:/view/Proposals?id=" + userId;
    }

}
