package com.Boardimak.main.restController;
/*
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.Boardimak.main.model.Property;
import com.Boardimak.main.repository.PropertyRepository;

@Controller
//@RestController
@RequestMapping("/owner")
public class propertyRestController {

	PropertyRepository propertyRepo;
	Property property;
	
	@Autowired
	public propertyRestController(PropertyRepository obj) {
		this.propertyRepo = obj;
	}

	@PostMapping("/property")
	@ResponseBody
	public void saveProertyJSON(@RequestBody Property propertyOBJ) {
		this.property = propertyOBJ;
		propertyRepo.save(property);
	}

	
	@GetMapping("/property")
	@ResponseBody
	public List<Property> findProerties() {
	
		return propertyRepo.findAll();
	}

	@GetMapping("/property/{propertyId}")
	@ResponseBody
	public Property findProerty(@PathVariable int propertyId) {
	
		Property searchedProp = null;
		Optional<Property> results = propertyRepo.findById(propertyId);
		
		if(results.isPresent()){
			searchedProp =  results.get();
		}
		
		return searchedProp;
	}

	@GetMapping("/test")
	public String showCity(HttpServletRequest request) {
		
		List<Property> properties = new ArrayList<>();
			for(Property propertyObject : propertyRepo.findAll()) {
				properties.add(propertyObject);
			}
		request.setAttribute("properties",properties);
		return "all-properties";
	}
	
	@PostMapping("/save-property")
	public String registerUser(@ModelAttribute Property newProperty,BindingResult bindingResult,HttpServletRequest request) {
		propertyRepo.save(newProperty);
		return "redirect:/owner/test";
	}
	
	@RequestMapping("/delete-property")
	public String deleteUser(@RequestParam int id,HttpServletRequest request) {
		propertyRepo.deleteById(id);
		return "redirect:/owner/test";
	}


}
*/