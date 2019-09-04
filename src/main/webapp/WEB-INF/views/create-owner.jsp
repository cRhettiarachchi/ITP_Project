<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/main.css">
<link rel="stylesheet" href="/resources/css/dashboard.css">
<link rel="stylesheet" href="/resources/css/owner-property.css">
	
</head>
<body>

<div class = "container">
	<div class = "col-md-10">
		<form id="Stripe-form" method="post" action="#">
         <div class="row">
            <div class="col-md-6">
               <div class="form-group row">
				 <input type="text" class="col-sm-11" id = "firstName" placeholder="First Name">
                 <input type="text" class="col-sm-11" id = "lastName" placeholder="Last Name">
                 <input type="text" class="col-sm-11" id = "email" placeholder="Enter Email">
            </div>
         </div>
         <div class="col-md-6">
            <div class="form-group row">
				<input type="text" class="col-sm-11" id = "accountNumber" placeholder="Enter account number">
				<input type="text" class="col-sm-11" id = "address1" placeholder="Adress">
				<input type="text" class="col-sm-11" id = "city" placeholder="city">
				<input type="text" class="col-sm-11" id = "state" placeholder="state">
				<input type="text" class="col-sm-11" id = "postal" placeholder="Postal">
         </div>
      </div>
     </div>
        <div class="row">
            <div class="col-md-6">
              <div class="form-group row">
                <input type="text" class="col-sm-12 " name="mobile" placeholder="Enter Mobile number">
              </div>   
            </div>
                       
      </div>

            <button class="btn btn-primary btn-block" id="submitButton" type="submit" value = "submit">
                  Add this card
			</button>
       </form>
    </div>
</div>

<script src="https://js.stripe.com/v3/"></script>
<script type="text/javascript">
	  var stripe = Stripe('pk_test_fiNmKZ5r1VOsJqi4PLEnRqsu006QD8Fb6K');

      var form = document.getElementById('Stripe-form');
      form.addEventListener('submit', function (event) {
          event.preventDefault();
          alert("working");
			handleCreating();
      });

      document.getElementById("submitButton").addEventListener("click", function(){
    	  alert("working");
    	  handleCreating();
    	});

    //handle card submission
      function handleCreating() {
    	  const accountResult = await stripe.createToken('account', {
    		  business_type: 'individual',
    		  individual: {
    		      first_name: document.querySelector('#firstName').value,
    		      last_name: document.querySelector('#lastName').value,
    		      address: {
    		        line1: document.querySelector('#address1').value,
    		        city: document.querySelector('#city').value,
    		        state: document.querySelector('#state').value,
    		        postal_code: document.querySelector('#postal').value,
    		      },
    		   	  email: document.querySelectory('#email').value,
    		      ssn_last_4_provided: true
    		    },
    		    tos_shown_and_accepted: true,
    		  });
                  // Send the token to your server.
                  var token = accountResult.token.id;
                  var email = $('#email').val();
                  $.post(
                      "/create/account",
                      {token: token, email: email},
                      function (data) {
                          alert(data.details);
                      }, 'json');
    	}
</script>
</body>
</html>