package com.zss.api;

import com.zss.api.commons.BaseRepositoryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository extends BaseRepositoryFactory  {

    private static final String SQL_MAPPER_PREFIX = "com.zss.api.Person.";

    private static final String SELECT = "selectById";
    private static final String INSERT = "insert";

    List<Person> getPersons() {
        return super.getSqlSession().selectList(SQL_MAPPER_PREFIX + SELECT);
    }

    void save(Person person) {
        super.getSqlSession().insert(SQL_MAPPER_PREFIX + INSERT,person);
    }

}
