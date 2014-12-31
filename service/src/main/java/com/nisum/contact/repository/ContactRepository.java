package com.nisum.contact.repository;

import com.nisum.contact.configuration.DatabaseConfiguration;
import com.nisum.contact.configuration.MybatisMapperConfiguration;
import com.nisum.contact.domain.ContactRequest;
import com.nisum.contact.repository.mapper.IContactMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {
    @Autowired
    IContactMapper contactMapper;
    public void saveContact(ContactRequest request) throws Exception {
        contactMapper.addContact(request.getFirstName(), request.getLastName());
    }
}
