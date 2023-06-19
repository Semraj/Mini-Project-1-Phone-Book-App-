package com.ashokit.phonebookapp.repository;

import com.ashokit.phonebookapp.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {

    public List<Contact> findByActiveSw(String status);

}
