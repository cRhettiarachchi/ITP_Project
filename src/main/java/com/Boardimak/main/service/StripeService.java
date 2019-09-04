package com.Boardimak.main.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Boardimak.main.model.*;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.Token;
import com.stripe.model.Transfer;
import com.stripe.net.RequestOptions;


@Service
public class StripeService {
	
	@Autowired
	UserService userservice;
	
	@Autowired
	OwnerService ownerservice;
	
	@Autowired
	PaymentService paymentservice;

	@Value("${stripe.key.secret}")
	private String API_SECRET_KEY;
	
	public String createCustomer(String token, String email) {
		// get the Buyer object using the email
        Buyer buyer = userservice.getIdByEmail(email);
        
        if(buyer == null) { 
        	return "Wrong Email";
        }else if(buyer.getStripeID() != null) {
        	payMoney();
        	return "Alread Have An Account";
        }
        
        // initialize the Stripe id as null
		String StripeId = null;
		
        try {
        	// get the stripe Secret key from application.properties
            Stripe.apiKey = API_SECRET_KEY;
            Map<String, Object> customerParams = new HashMap<>();
            
            //add customer unique id here to track them in your web application
            customerParams.put("description", "Customer for " + buyer.getEmail());
            customerParams.put("email", buyer.getEmail());

            // ^ obtained with Stripe.js through the UI
            customerParams.put("source", token);
            
            
            //create a new customer
            Customer customer = Customer.create(customerParams);
            
            
            // get the new customer's unique customer Stripe id 
            StripeId = customer.getId();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
       // set the stripe id in the Buyer object 
       buyer.setStripeID(StripeId);
       // update the stripe id of the customer in the buyer table
       userservice.updateStripeID(buyer);
       
       return StripeId;
    } // end of create Customer Function
	
	
	
	public int payMoney() {
		System.out.println("working");
		return 0;
	} // 
	
	
	
	/* createAccount functions to create stripe accounts
	 * At the moment the function only accepts email 
	 * In the future it should accept a bank account token from the front end*/
	public String createAccount(String token, String email) throws StripeException {
		
		Stripe.apiKey = API_SECRET_KEY;
		
		Owner owner = ownerservice.getAllusersByemail(email);
		
		if(owner == null) {
			return "wrong email";
		}else if(owner.getStripeAccountId() != null) {
			return "already has an account";
		}
		
		// Create a token to use for the Custom account creation
		String t = createAccountToken(owner);

		// Creating the Custom Account
		Map<String, Object> params = new HashMap<>();
		params.put("country", "US");
		params.put("type", "custom");
		params.put("default_currency", "usd");
		params.put("requested_capabilities", Arrays.asList("card_payments", "transfers"));
		
		// Got from the createAccountToken Method
		params.put("account_token", t); 
		
		// Got from stripe.js ( Front end )
		params.put("external_account", token);
		
		// create an account
		Account account = Account.create(params); 
		
		// get the account ID
		String accountId = account.getId();
		// set the Stripe account id of the modelclass
		owner.setStripeAccountId(accountId);
		
		// update the database
		ownerservice.saveOwner(owner);

		return accountId;
	} // end of createAccount method
	
	
	
	/*This method function to create a token for the stripe create account
	 * */
	
	public String createAccountToken(Owner owner) throws StripeException {
		Stripe.apiKey = API_SECRET_KEY;
		
		Map<String, Object> tokenParams = new HashMap<String, Object>();
		Map<String, Object> accountParams = new HashMap<String, Object>();
		Map<String, Object> individualParams = new HashMap<String, Object>();
		individualParams.put("first_name", owner.getFirstName());
		individualParams.put("last_name", owner.getLastName());
		individualParams.put("email", owner.getEmail());
		accountParams.put("business_type", "individual");
		accountParams.put("individual", individualParams);
		accountParams.put("tos_shown_and_accepted", true);
		tokenParams.put("account", accountParams);
		
		Token t = Token.create(tokenParams);

		return t.getId();
	}
	
	public PaymentIntent createPayment() throws StripeException {
		Stripe.apiKey = API_SECRET_KEY;
		
		Customer c =Customer.retrieve("cus_Fi302WGUBbXaKg");
		
		Map<String, Object> paymentIntentParams = new HashMap<>();
		paymentIntentParams.put("amount", 2000);
		paymentIntentParams.put("currency", "usd");
		ArrayList<String> paymentMethodTypes = new ArrayList<>();
		paymentMethodTypes.add("card");
		paymentIntentParams.put("payment_method_types", paymentMethodTypes);
		paymentIntentParams.put("customer", "cus_Fi302WGUBbXaKg");
		paymentIntentParams.put("on_behalf_of", "acct_1FCcx7LrjxKaXEIu");
		paymentIntentParams.put("payment_method", c.getDefaultSource());
		
		PaymentIntent paymentIntent = PaymentIntent.create(paymentIntentParams);
		
		paymentservice.createPaymentObject(paymentIntent);

		return paymentIntent;
	}
	
}
