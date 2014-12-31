package com.nisum.contact.controller;

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

@Slf4j
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/contact/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveContact(
            @RequestBody ContactRequest prepackRequest) {

        try {
            log.debug("Prepack Service request: "
                    + JsonUtility.getAsJSONString(prepackRequest));
            ContactResponse contactResponse = contactService
                    .saveContact(prepackRequest);
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

}
