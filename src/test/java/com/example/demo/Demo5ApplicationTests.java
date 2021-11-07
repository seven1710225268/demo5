package com.example.demo;

import com.example.demo.User.user;
import com.example.demo.dao.userdao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Demo5ApplicationTests {
    user user1 = new user("171022526809", "87872610",true);
    user user2 = new user("171022526810", "87872610",true);
    user user3 = new user("171022526811", "87872610",true);

    @Test
    public void saveDemoTest() {
        userdao.createUser(user1);
        userdao.createUser(user2);
        userdao.createUser(user3);
    }

    @Test
    public void removeDemoTest() {
        userdao.deleteUser(user2);
    }

}
