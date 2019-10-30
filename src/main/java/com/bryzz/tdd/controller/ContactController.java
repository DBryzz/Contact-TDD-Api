package com.bryzz.tdd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bryzz.tdd.model.Contact;
import com.bryzz.tdd.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@GetMapping("/contacts")
	public List<Contact> retrieveAllContacts() {
		return contactService.getAllContacts();
	}

}
