package com.bryzz.tdd.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bryzz.tdd.model.Contact;
import com.bryzz.tdd.repository.ContactRepository;

@RunWith(MockitoJUnitRunner.class)		//@SpringBootTest
public class ContactServiceTest {
	
	@InjectMocks
	private ContactService contactService;
	
	@Mock
	private ContactRepository contactRepo;
	
	@Test
	public void generateContactEmailAndFullName() {
		List<Contact> contactList = Arrays.asList(
				new Contact(10001, "Brice", "Domou", 670000001),
				new Contact(10002, "Serge", "Lobe", 670000002),
				new Contact(10003, "Durran", "Teke", 670000003),
				new Contact(10004, "Bruno", "Serkwi", 670000004),
				new Contact(10005, "Tertulien", "Ngouleu", 670000005),
				new Contact(10006, "Percy", "Ayuk", 670000006),
				new Contact(10007, "Stephen", "Nnouka", 670000007));
		
			when(contactRepo.findAll()).thenReturn(contactList);
			
			List<Contact> actualList = contactService.getAllContacts();
				
		
		assertEquals("Brice", actualList.get(0).getfName());
		assertEquals("Brice Domou", actualList.get(0).getName());
		assertEquals("domou.brice@contact.info", actualList.get(0).getEmail());

		
	}

}
