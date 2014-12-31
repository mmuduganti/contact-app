package com.nisum.contact.controller;

import com.nisum.contact.domain.Contact;
import com.nisum.contact.domain.ContactRequest;
import com.nisum.contact.domain.ContactResponse;
import com.nisum.contact.service.ContactService;
import com.nisum.contact.util.JsonUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveContact(
            @RequestBody ContactRequest contactRequest) {
        try {
            ContactResponse contactResponse = contactService
                    .saveContact(contactRequest);
            log.debug("Contact Service response: "
                    + JsonUtility.getAsJSONString(contactResponse));
            contactResponse.setHttpStatus(HttpStatus.OK.value());
            return new ResponseEntity<ContactResponse>(contactResponse,
                    HttpStatus.OK);
        } catch (Exception exception) {
            log.error(
                    "Got an exception in ContactController and the cause is: %s",
                    exception.getMessage());
        }
        return null;

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listContacts() throws Exception {
        List<Contact> contacts = contactService.retrieveContacts();
        return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
    }

}
