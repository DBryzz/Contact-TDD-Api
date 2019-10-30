package com.bryzz.tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bryzz.tdd.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
