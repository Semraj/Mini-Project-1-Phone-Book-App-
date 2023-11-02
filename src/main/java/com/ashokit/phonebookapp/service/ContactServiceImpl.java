package com.ashokit.phonebookapp.service;

import com.ashokit.phonebookapp.entity.Contact;
import com.ashokit.phonebookapp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;
    @Override
    public String saveContact(Contact contact) {
        contact.setActiveSw("Y");
        contact = contactRepository.save(contact);

//        UUID.randomUUID().toString();// Random Uid generation
         if (contact.getContactId()!=null)
         return "Contact Saved";
         else
             return "Contact Failed to Saved";
    }

    @Override
    public List<Contact> getAllContacts() {
       /* List<Contact> Contacts = contactRepository.findAll();
        return Contacts;*/
        List<Contact> active = contactRepository.findByActiveSw("Y");
        return active;
    }

    @Override
    public Contact getContactById(Integer contactId) {
        Optional<Contact> findContactById = contactRepository.findById(contactId);
        if(findContactById.isPresent()){
            return findContactById.get();
        }
        return null;
    }
//Update Logics
    @Override
    public String updateContact(Contact contact) {
       if(contactRepository.existsById(contact.getContactId())) {
           contactRepository.save(contact);
           return "Record Updated";
       }

        return null;
    }

    @Override
    public String deleteContactById(Integer contactId) {
       /* if(contactRepository.existsById(contactId)){
            contactRepository.deleteById(contactId);
            return "Record Deleted";
        }
        else {
            return "No record found";
        }*/
        Optional<Contact> findById = contactRepository.findById(contactId);
        if (findById.isPresent()){
           Contact contact = findById.get();
           contact.setActiveSw("N");
            contactRepository.save(contact);
            return "Deleted";
        }
        else {
            return "Not Found";
        }
    }
}
