package com.bryzz.tdd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bryzz.tdd.model.Contact;
import com.bryzz.tdd.repository.ContactRepository;

@Component
public class ContactService {

	@Autowired
	ContactRepository contactRepo;
	
	public List<Contact> getAllContacts() {
		List<Contact> list = contactRepo.findAll();
		for(Contact contact:list) {
			contact.setName(contact.getfName() + " " + contact.getlName());
			String mail = contact.getlName()+"."+contact.getfName() +"@contact.info";
			contact.setEmail(mail.toLowerCase());
		}
		return list;
		
	}
}
