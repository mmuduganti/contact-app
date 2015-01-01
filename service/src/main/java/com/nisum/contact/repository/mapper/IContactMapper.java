package com.nisum.contact.repository.mapper;

import com.nisum.contact.domain.Contact;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface IContactMapper {
    @Insert("INSERT INTO CONTACT ("
            + "FIRST_NAME,"
            + "LAST_NAME,"
            + "PHONE_NUM) "
            + "VALUES"
            + "(#{firstName},#{lastName},#{phoneNum})")

    @Options(flushCache = true, statementType = StatementType.PREPARED)
    void addContact(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("phoneNum") String phoneNum
    );
    
    @Select("SELECT FIRST_NAME as firstName, LAST_NAME as lastName, PHONE_NUM as phoneNum FROM CONTACT")
    List<Contact> retrieveContacts();

}
