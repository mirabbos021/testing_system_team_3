package com.company.service;

import com.company.database.Database;
import com.company.entity.User;
import com.company.payload.Result;
import com.company.payload.UserDTO;

public interface UserService {
    static User getUserByPhoneNUmber(String phoneNumber) {
        for (User user : Database.getUsers()) {
            if (user.getPhoneNumber().equals(phoneNumber))
                return user;
        }
        return null;
    }

    Result create(UserDTO userDTO);

    Result get();

    void edit();

    void delete();

}
