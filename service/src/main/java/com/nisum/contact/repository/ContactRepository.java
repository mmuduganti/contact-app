package com.nisum.contact.repository;

import com.nisum.contact.configuration.DatabaseConfiguration;
import com.nisum.contact.configuration.MybatisMapperConfiguration;
import com.nisum.contact.domain.Contact;
import com.nisum.contact.domain.ContactRequest;
import com.nisum.contact.repository.mapper.IContactMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepository {
    @Autowired
    IContactMapper contactMapper;
    public void saveContact(ContactRequest request) throws Exception {
        contactMapper.addContact(request.getFirstName(), request.getLastName());
    }
    
    public List<Contact> retrieveContacts() throws Exception {
        return contactMapper.retrieveContacts();
        
    }
}
