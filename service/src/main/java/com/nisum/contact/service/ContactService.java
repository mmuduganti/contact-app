package com.nisum.contact.service;

import java.util.Date;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.contact.domain.ContactRequest;
import com.nisum.contact.domain.ContactResponse;
import com.nisum.contact.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
    @Setter
	private ContactRepository contactRepository;
	
	public ContactResponse saveContact(ContactRequest contactRequest) throws Exception{
		ContactResponse contactResponse = new ContactResponse();
		contactRepository.saveContact(contactRequest);
		contactResponse.setTs(new Date());
        return contactResponse;
		
	}
}
