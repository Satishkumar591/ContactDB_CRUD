package com.contactdb.contactdbservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.contactdb.contactdbservice.DAO.ContactDAO;
import com.contactdb.contactdbservice.model.ContactDB;

@Controller
public class ContactContorller{
	
	@Autowired
	private ContactDAO contactDAO;
	
	
	@GetMapping("/")
	public String listContact(Model model) {
		
		model.addAttribute("listContact", contactDAO.list());
		
		return "index";
	}
	
	@GetMapping("/showContactForm")
	public String showContactForm(Model model) {
		
		ContactDB contactdb = new ContactDB();
		
		model.addAttribute("contactdb", contactdb);
		
		return "new_contact";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("contactdb") ContactDB contactDb) {
		
		//save contact to database
		contactDAO.save(contactDb);
		return "redirect:/";
		
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") int id, Model model) {
		
		ContactDB contactDb = contactDAO.getById(id);
		model.addAttribute("contactdb", contactDb);
		return "update_contact";
	}
	
	@GetMapping("/deleteForm/{id}")
	public String deleteForm(@PathVariable(value ="id") int id) {
		contactDAO.deleteById(id);
		return "redirect:/";
	}

}
