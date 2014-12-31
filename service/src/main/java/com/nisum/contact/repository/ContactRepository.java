package com.nisum.contact.repository;

import com.nisum.contact.configuration.DatabaseConfiguration;
import com.nisum.contact.configuration.MybatisMapperConfiguration;
import com.nisum.contact.domain.ContactRequest;
import com.nisum.contact.repository.mapper.IContactMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {
    public void saveContact(ContactRequest request) throws Exception {
        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
        SqlSession rmsSqlSession = (SqlSession) new MybatisMapperConfiguration().sqlSessionFactory(databaseConfiguration.dataSource());

        if (!(rmsSqlSession.getConfiguration().hasMapper(IContactMapper.class))) {
            rmsSqlSession.getConfiguration().addMapper(IContactMapper.class);
        }


        IContactMapper contactMapper = rmsSqlSession.getMapper(IContactMapper.class);
        contactMapper.addContact(request.getFirstName(), request.getLastName());
    }
}
