package com.bryzz.tdd.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bryzz.tdd.model.Contact;
import com.bryzz.tdd.service.ContactService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ContactController.class)
//@SpringBootTest
public class ContactControllerTest {
	
	@Autowired 
	private MockMvc mvcMock;
	
	@MockBean
	ContactService contactService;
	
	@Test
	public void contactTest_basis() throws Exception {
		when(contactService.getAllContacts()).thenReturn(Arrays.asList(
				new Contact(10001, "Brice", "Domou", 670000001),
				new Contact(10002, "Serge", "Lobe", 670000002)));

		RequestBuilder request = MockMvcRequestBuilders
				.get("/contacts")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvcMock.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:10001, number:670000001},"
						+ "{id:10002, number:670000002}]"))
				.andReturn();

				
	}
	
}
