package com.nisum.contact.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactRequest {

	private String firstName;
	private String lastName;

}
