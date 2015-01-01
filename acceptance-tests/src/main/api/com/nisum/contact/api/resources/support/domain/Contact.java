package com.nisum.contact.api.resources.support.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by mmuduganti on 12/31/14.
 */
@Setter
@Getter
@ToString
public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNum;
}
