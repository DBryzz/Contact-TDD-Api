package com.bryzz.tdd.controller;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContactControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	public void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/contacts", String.class);
		JSONAssert.assertEquals("[{id=10001}, {id=10002}, {id=10003}, {id=10004}, {id=10005}, {id=10006}, {id=10007}]", response, false);
	}
}
