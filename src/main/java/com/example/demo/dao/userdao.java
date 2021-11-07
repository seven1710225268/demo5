package com.example.demo.dao;
import com.example.demo.User.user;
import com.example.demo.utils.Utilities;

import com.mongodb.client.result.DeleteResult;
import org.springframework.data.mongodb.core.MongoOperations;

public class userdao{

    private static final MongoOperations mongoOperations = Utilities.GetMongoTemplate();

    public static boolean createUser(user user) {
        if (mongoOperations.findById(user.getUserName(), user.class) != null) {
            return false;
        }
        mongoOperations.insert(user);
        return true;
    }

    public static boolean deleteUser(user user) {
        DeleteResult deleteResult = mongoOperations.remove(user);
        return true;
    }

    public static user retrieveUser(String userName) {
        return mongoOperations.findById(userName, user.class);
    }
}
