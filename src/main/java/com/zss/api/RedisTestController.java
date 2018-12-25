package com.zss.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@Slf4j
public class RedisTestController {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonRedisRepository personRedisRepository;

    @GetMapping("/redis")
    public void tet() {
        Person person = new Person();
        person.setName("lisi1");
        person.setGender("男1");
        String id = UUID.randomUUID().toString();
        person.setId(id);
        Person person1 = new Person();
        person1.setName("lisi2");
        person1.setGender("男2");
        String id1 = UUID.randomUUID().toString();
        person.setId(id1);

        ArrayList<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person1);

        //只操作redis
        personRedisRepository.save(list);
        //只操作mysql
        personRepository.save(person);
    }
    @GetMapping("/redis/res/{id}")
    public void getRedisData(@PathVariable String id) {
        Person one = personRedisRepository.findOne(id);
        log.info("123: {}", one);
    }

}


