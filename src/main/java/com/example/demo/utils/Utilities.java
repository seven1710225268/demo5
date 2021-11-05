package com.example.demo.utils;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import com.mongodb.client.MongoClients;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Utilities {
    public static String encodeBase64Password(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
    }

    public static String decodeBase64Password(String base64encodedString) {
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        return new String(base64decodedBytes, StandardCharsets.UTF_8);
    }


    public static MongoOperations GetMongoTemplate() {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(), "myDB1"));
    }
}
