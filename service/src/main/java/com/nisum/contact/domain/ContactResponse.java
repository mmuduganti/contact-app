package com.nisum.contact.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nisum.contact.util.JsonDateSerializer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
@ToString
public class ContactResponse {
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date ts;
	private int httpStatus;
	private String errorMessage;


}
