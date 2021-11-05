package com.example.demo.service;
import com.example.demo.User.user;
import com.example.demo.dao.userdao;
import com.example.demo.utils.Utilities;
import com.example.demo.utils.JWTUtils;

public class LoginService {
    public String toSignUp(String userName, String password) {
        user user = userdao.retrieveUser(userName);
        if (user != null) {
            return "user already exists";
        }

        String encodedPassword = Utilities.encodeBase64Password(password);
        user = new user(userName, encodedPassword, false);

        if (userdao.createUser(user)) {
            return JWTUtils.createToken(user.getUserName(), user.getPassword(), 1000*3600*3);
        }

        return "error";
    }

    public String toLogin(String userName, String password) {
        user user = userdao.retrieveUser(userName);
        if (user == null) {
            return "user name not found";
        }

        String decodedPassword = Utilities.decodeBase64Password(user.getPassword());

        if (decodedPassword.equals(password)) {
            return JWTUtils.createToken(user.getUserName(), user.getPassword(), 1000*3600*3);
        }

        return "password not right";
    }
}
