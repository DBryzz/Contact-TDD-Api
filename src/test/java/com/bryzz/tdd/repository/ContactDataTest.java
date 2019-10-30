package com.bryzz.tdd.repository;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bryzz.tdd.model.Contact;
import com.bryzz.tdd.repository.ContactRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactDataTest {
	
	@Autowired
	private ContactRepository contactRepo;
	
	
	
	@Test
	public void generateContactEmailAndFullName() {
		
			List<Contact> actualList = contactRepo.findAll();
				
		
		assertEquals(7, actualList.size());
		assertEquals("Domou", actualList.get(0).getlName());

		
	}

}
