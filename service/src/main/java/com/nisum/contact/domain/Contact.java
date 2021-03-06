package com.nisum.contact.domain;

import lombok.*;

/**
 * Created by mmuduganti on 12/31/14.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNum;
}
