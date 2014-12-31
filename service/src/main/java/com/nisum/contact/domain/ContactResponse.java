package com.nisum.contact.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.DateTime;

import java.util.Date;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
@ToString
public class ContactResponse {
    private DateTime ts;
    private int httpStatus;
    private String errorMessage;
}
