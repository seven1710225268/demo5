package com.example.demo.User;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.util.List;

@Data
public class user {
    @MongoId
    private String userName;
    private String password;
    private Boolean admin;

    private Integer articlesNum;
    private List<String> articleList;

    public user(String userName, String password, Boolean admin) {
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.articlesNum = 0;
    }
}