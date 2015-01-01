package com.nisum.contact.repository.mapper;

import com.nisum.contact.domain.Contact;
import com.nisum.contact.domain.ContactRequest;
import com.nisum.contact.repository.sql.ContactSelectProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
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
    void addContact(ContactRequest request);
    
    @SelectProvider(type=ContactSelectProvider.class, method="retrieveContacts")
    List<Contact> retrieveContacts(@Param("firstName") String firstName);
}
