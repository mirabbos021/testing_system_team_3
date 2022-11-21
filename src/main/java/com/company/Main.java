package com.company;

import com.company.database.Database;
import com.company.entity.Role;
import com.company.entity.User;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database.addUser(List.of(new User(1,"Numonov Mirabbos","9991555021","12345678", Role.ADMIN)));
        Database.userToPdf();
        System.out.println(Database.getUsers());
        try {
            Desktop.getDesktop().open(new File(Database.MAIN_FILE,"users.pdf"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}