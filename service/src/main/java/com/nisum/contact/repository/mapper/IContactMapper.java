package com.nisum.contact.repository.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.mapping.StatementType;

public interface IContactMapper {
	@Insert("INSERT INTO CONTACT ("
			+ "FIRST_NAME,"
			+ "LAST_NAME) "
			+ "VALUES"
			+ "(#{firstName},#{lastName})")
	
	@Options(flushCache = true, statementType = StatementType.PREPARED)
	void addContact(
			@Param("firstName") String firstName,
			@Param("lastName") String lastName
	);

}
