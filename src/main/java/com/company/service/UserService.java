package com.company.service;

import com.company.payload.Result;
import com.company.payload.UserDTO;

public interface UserService {
    Result create(UserDTO userDTO);
    Result get();
    void edit();
    void delete();

}
