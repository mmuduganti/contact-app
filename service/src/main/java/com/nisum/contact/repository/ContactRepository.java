package com.nisum.contact.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nisum.contact.domain.Contact;
import com.nisum.contact.domain.ContactRequest;
import com.nisum.contact.repository.mapper.IContactMapper;

@Repository
public class ContactRepository {
    @Autowired
    IContactMapper contactMapper;
    public void saveContact(ContactRequest request) throws Exception {
        contactMapper.addContact(request.getFirstName(), request.getLastName(),request.getPhoneNum());
    }
    
    public List<Contact> retrieveContacts() throws Exception {
        return contactMapper.retrieveContacts();
        
    }
}
