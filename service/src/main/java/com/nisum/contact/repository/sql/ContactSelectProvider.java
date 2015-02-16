package com.nisum.contact.repository.sql;


import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public final class ContactSelectProvider {

    public static String retrieveContacts(Map params) {
        return new SQL() {{
            SELECT("FIRST_NAME as firstName, LAST_NAME as lastName, PHONE_NUM as phoneNum");
            FROM("CONTACT");
            WHERE("FIRST_NAME=#{firstName}");
        }}.toString();
    }
}