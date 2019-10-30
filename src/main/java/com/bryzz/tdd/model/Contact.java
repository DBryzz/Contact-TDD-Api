package com.bryzz.tdd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@JsonIgnore
	private String fName;
	@JsonIgnore
	private String lName;
	private int number;

	@Transient
	private String email;

	@Transient
	private String name;

	protected Contact() {

	}

	public Contact(int id, String fName, String lName, int number) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.number = number;
		// this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("Contact [id=%s, fName=%s, lName=%s, number=%s, email=%s, name=%s]", id, fName, lName,
				number, email, name);
	}

	/*
	 * @Override public String toString() { return
	 * String.format("Contact [id=%s, name=%s, number=%s, email=%s]", id, name,
	 * number, email); }
	 */

}
