package com.ashokit.phonebookapp.controller;

import com.ashokit.phonebookapp.entity.Contact;
import com.ashokit.phonebookapp.service.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "This is a Contact Management Project")
public class ContactRestController {
    @Autowired
    private ContactService contactService;
    @ApiOperation(value = "This is to save Contact")
    @PostMapping("/contact")
    public String createContact(@RequestBody Contact contact){
    String con = contactService.saveContact(contact);
    return con;
}

    @GetMapping("/contacts")
    public List<Contact> getAllContacts(){
        List<Contact> allContacts = contactService.getAllContacts();
        return allContacts;
    }

    @GetMapping("/contact/{contactId}")
    public Contact getContactById(@PathVariable Integer contactId){
        return contactService.getContactById(contactId);
    }

    @PutMapping("/contact")
    public String updateContact(@RequestBody Contact contact){
        return contactService.updateContact(contact);
    }
    @DeleteMapping("/contact/{contactId}")
    public String deleteContact(@PathVariable Integer contactId){
        return contactService.deleteContactById(contactId);
    }
}
