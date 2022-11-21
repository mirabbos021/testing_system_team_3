package com.company.service;

import com.company.database.Database;
import com.company.entity.User;
import com.company.payload.Result;
import com.company.payload.UserDTO;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public Result create(UserDTO userDTO) {
        Result result = new Result();
        String check = checkParams(userDTO);
        if (!check.equals("ok")){
            result.setMessage(check);
            result.setSuccess(false);
            return result;
        }
        User user=new User();

        List<User> users= Database.getUsers();

        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setId(users.get(users.size()-1).getId()+1);

        users.add(user);
        Database.addUser(users);
        result.setMessage(check);
        result.setSuccess(true);
        return result;
    }

    @Override
    public Result get() {

        return null;
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }

    private String checkParams(UserDTO userDTO) {
        if (userDTO == null) {
            return "Data not found";
        }
        if (userDTO.getFullName() == null || userDTO.getFullName().isBlank()) {
            return "Full name is required";
        }
        if (userDTO.getPhoneNumber() == null || userDTO.getPhoneNumber().isBlank()) {
            return "Phone number is required";
        }
        if (userDTO.getPassword() == null || userDTO.getPassword().isBlank()) {
            return "Password is required";
        }
        if (isRepeated(userDTO)){
            return "Already registered with this phone";
        }
        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())){
            return "Passwords do not matches";
        }
        return "ok";
    }
    private boolean isRepeated(UserDTO userDTO){
        for (User user : Database.getUsers()) {
            if (user.getPhoneNumber().equals(userDTO.getPhoneNumber())){
                return true;
            }
        }
        return false;
    }
}
