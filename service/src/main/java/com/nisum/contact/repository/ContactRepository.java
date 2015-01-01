package com.nisum.contact.repository;

import com.nisum.contact.domain.Contact;
import com.nisum.contact.domain.ContactRequest;
import com.nisum.contact.repository.mapper.IContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepository {
    @Autowired
    IContactMapper contactMapper;
    public void saveContact(ContactRequest request) throws Exception {
        contactMapper.addContact(request);
    }
    
    public List<Contact> retrieveContacts(String firstName) throws Exception {
        return contactMapper.retrieveContacts(firstName);
        
    }
}
