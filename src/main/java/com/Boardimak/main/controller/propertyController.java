package com.Boardimak.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Boardimak.main.model.Property;
import com.Boardimak.main.service.PropertyService;

@Controller
public class propertyController {
	
	@Autowired
	PropertyService pService;

	@GetMapping("/")
	public String hello(HttpServletRequest request) {
		request.setAttribute("properties",pService.showAll());
		return "index";
	}
	
	@GetMapping("/property")
	public String singleProperty(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("property",pService.getAProperty(id));
		return "property";
	}
	
	@GetMapping("/edit-property")
	public String editProperty() {
		return "edit-property";
	}
	
	@GetMapping("/owner")
	public String testingProperty() {
		return "owner-properties";
	}
	
	@GetMapping("/owner/all")
	public String allProperties() {
		return "owner-properties-full";
	}
	
	@GetMapping("/home")
	public String allPropertiesView() {
		return "home-page";
	}
	
	@GetMapping("/admin/property")
	public String showProperties(HttpServletRequest request) {
		request.setAttribute("properties",pService.showAll());
		return "all-properties";
	}
	
	@GetMapping("/owner/property")
	public String ownerShowProperties(HttpServletRequest request) {
		request.setAttribute("properties",pService.showAll());
		return "owner-properties-full";
	}
	
	@PostMapping("/admin/property")
	public String adminSaveObject(@ModelAttribute Property newProperty,BindingResult bindingResult,HttpServletRequest request) {
		pService.saveProperty(newProperty);
		return "redirect:/admin/property";
	}
	
	
	@PostMapping("/owner/property")
	public String saveObject(@ModelAttribute Property newProperty,BindingResult bindingResult,HttpServletRequest request) {
		pService.saveProperty(newProperty);
		return "redirect:/owner/my-properties";
	}
	
	@RequestMapping("/owner/delete-property")
	public String deleteProperty(@RequestParam int id,HttpServletRequest request) {
		pService.deleteProperty(id);
		return "redirect:/owner/property";
	}
	
	@RequestMapping("/admin/delete-property")
	public String adminDeleteProperty(@RequestParam int id,HttpServletRequest request) {
		pService.deleteProperty(id);
		return "redirect:/admin/property";
	}

	@RequestMapping("/owner/property/DeactivateProperty")
	public String deactivatePropertyStatus(@RequestParam int id,HttpServletRequest request) {
		Property ob = pService.getAProperty(id);
		ob.setStatus("Offline");
		System.out.println(ob);
		pService.saveProperty(ob);
		return "redirect:/owner/property";
	}
	
	@RequestMapping("/owner/property/ActivateProperty")
	public String activatePropertyStatus(@RequestParam int id,HttpServletRequest request) {
		Property ob = pService.getAProperty(id);
		ob.setStatus("Active");
		System.out.println(ob);
		pService.saveProperty(ob);
		return "redirect:/owner/property";
	}
	
	@RequestMapping("/admin/property/DeactivateProperty")
	public String deactivateProperty(@RequestParam int id,HttpServletRequest request) {
		Property ob = pService.getAProperty(id);
		ob.setStatus("Offline");
		System.out.println(ob);
		pService.saveProperty(ob);
		return "redirect:/admin/property";
	}
	
	@RequestMapping("/admin/property/ActivateProperty")
	public String activateProperty(@RequestParam int id,HttpServletRequest request) {
		Property ob = pService.getAProperty(id);
		ob.setStatus("Active");
		System.out.println(ob);
		pService.saveProperty(ob);
		return "redirect:/admin/property";
	}
	
	@GetMapping("/owner/edit-property")
	public String editProperty(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("property",pService.getAProperty(id));
		Property ob = pService.getAProperty(id);
		System.out.println(ob.getCity());
		
		return "edit-property";
	}

	@GetMapping("/owner/my-properties")
	public String showPropImages(HttpServletRequest request) {
		request.setAttribute("properties",pService.showAll());
		return "owner-properties-full";
	}
	
	@GetMapping("/owner/proposal")
	public String showProposals(HttpServletRequest request) {
		//request.setAttribute("properties",pService.showAll());
		return "proposal-review";
	}
	
}
